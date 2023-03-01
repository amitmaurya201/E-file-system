
-- -------------------  Dropping All Function ----------------------------

DROP FUNCTION IF EXISTS public.get_file_created_list(bigint, text, integer, integer, text, text); 

DROP FUNCTION IF EXISTS public.get_put_in_file_list(bigint, text, integer, integer, text, text); 

DROP FUNCTION IF EXISTS public.get_file_inbox_list(bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_file_sent_list(bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_file_movement_list(bigint,bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_receipt_movement_list(bigint,bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_file_created_list_count(bigint, text);

DROP FUNCTION IF EXISTS public.get_file_inbox_lists_count(bigint, text);

DROP FUNCTION IF EXISTS public.get_put_in_file_list_count(bigint, text);

DROP FUNCTION IF EXISTS public.get_file_sent_lists_count(bigint, text);

DROP FUNCTION IF EXISTS public.get_file_movement_list_count(bigint , bigint,  text);

DROP FUNCTION IF EXISTS public.get_receipt_movement_list_count(bigint , bigint, text);

DROP FUNCTION IF EXISTS public.get_receipt_created_list(bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_receipt_inbox_list(bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_receipt_sent_list(bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_file_correspondence_list(text, bigint, bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_all_attached_note_list(bigint, bigint);

DROP FUNCTION IF EXISTS public.get_attach_receipt_movement_list(bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_receipt_created_list_count(bigint, text);

DROP FUNCTION IF EXISTS public.get_receipt_inbox_list_count(bigint,text);

DROP FUNCTION IF EXISTS public.get_receipt_sent_list_count(bigint, text);

DROP FUNCTION IF EXISTS public.get_file_correspondence_list_count(text,bigint, bigint, text);

DROP FUNCTION IF EXISTS public.get_attach_receipt_movement_list_count(bigint, text);

DROP FUNCTION IF EXISTS public.get_closed_receipt_list(bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_closed_receipt_list_count(bigint, text);

------------------------File-created-list-----------------------------

CREATE OR REPLACE FUNCTION public.get_file_created_list(
	post_id bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(fmid bigint,docfileid bigint, filenumber character varying, subject character varying, category character varying, remark character varying, createdon timestamp without time zone, nature character varying, hasNote boolean) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
    
    declare 
        _query text;
        _keyword text;
        _offset bigint :=0;
        _limit bigint :=4;
        orderby text :='createdate';
       _order text :='desc';
    begin
      
_keyword := '''%'||keyword||'%''';
_query := 'Select fm.fmid as fileMovementId, f.docfileid as docfileid, f.filenumber as filenumber , f.subject as subject , categoryvalue as category ,
                        f.remarks as remark,f.createdate as createdon ,  f.nature as nature, (case when n.content ='''' then false when n.content is null then false else true end )as hasNote
     					FROM public.jet_process_docfile f  INNER JOIN public.md_category c 
                        ON c.categorydataid = f.categoryid
                        INNER JOIN public.jet_process_filemovement as fm ON fm.fileid = f.docfileid
						left join public.jet_process_filenote as fn on fn.filemovementid=fm.fmid
						left join public.jet_process_note as n on n.noteid = fn.noteid
						where fm.movementtype=0 AND currentstate = 1';
  IF (_start <0 OR _start IS NULL) THEN
            _offset:=0;
        ELSE
            _offset :=_start; 
        END IF;
        
        IF (_end <=0 OR _end IS NULL) THEN
                _limit :=4;
            ELSE
                _limit :=_end;
        END IF;   
        
        IF (orderByCol ='' OR orderByCol ='modifieddate' OR orderByCol ='modifiedDate' OR orderByCol IS NULL) THEN
                orderBy :='f.modifieddate';
            
        END IF;
        IF (orderByCol ='filenumber' OR orderByCol ='fileNumber') THEN
                orderBy :='f.filenumber';
            
        END IF;
        IF (orderByCol ='subject' ) THEN
                orderBy :='f.subject';
            
        END IF;
          IF (orderByCol ='createdOn' OR orderByCol ='createdon') THEN
                orderBy :='f.subject';
            
        END IF;
         IF (_orderByType ='' OR _orderByType IS NULL) THEN
                _order :='desc';
            ELSE
                _order :=_orderByType;
        END IF;
       
       
                        
                        IF post_id !=0 THEN
                        
                             _query := _query|| ' AND userpostid = '||post_id;
                            
                               if keyword IS NOT NULL THEN
                
                                     _query := _query||  ' AND (filenumber ilike'|| _keyword ||'OR subject ilike'|| _keyword ||'OR  categoryvalue ilike'|| _keyword ||')';
                          
                                     if orderby !=''  THEN 
                    
                                        _query := _query||' order by '||orderby;
                                        if _order !=''  THEN 

                                            _query := _query||' '||_order;
                                            if _offset >=0  THEN 

                                                 _query := _query||' offset '||_offset;
                                                if _limit >0  THEN 
                                                    _query := _query||' limit '||_limit;

                                                 END IF;
                                         END IF;
                                       
                                      END IF;
                                
                                    END IF;
                             END IF;
                             return query execute _query;
                END IF;
         
             
     end;
     
 
$BODY$;

ALTER FUNCTION public.get_file_created_list(bigint, text, integer, integer, text, text)
    OWNER TO postgres;
      
      
-----------------------Get-Put-in-file-List-----------------------
-- FUNCTION: public.get_put_in_file_list(text, bigint, text, integer, integer, text, text)

-- DROP FUNCTION IF EXISTS public.get_put_in_file_list(text, bigint, text, integer, integer, text, text);

CREATE OR REPLACE FUNCTION public.get_put_in_file_list(
	_type text,
	userpostid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(receiptid bigint, receiptnumber character varying, subject character varying, category character varying, createdate timestamp without time zone, remark character varying, viewpdfurl character varying, nature character varying, isread boolean, receiptmovementid bigint) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
  
  declare 
       nature text;
      _keyword text;
      _offset int;
      _limit int;
      _orderBy text;
      _order text;
      _query text;
      q1 text;
      q2 text;
      q3 text;
  begin
     nature :='';
 q1='select r.receiptid as receiptid, r.receiptnumber as receiptnumber, r.subject as subject, c.categoryvalue as category, r.createDate as createdate, r.remarks as remark, r.viewpdfurl as null, r.nature as nature,
     
    (
        case
            when rmt.movementtype=0 then true
            when rmt.pullbackremark IS NOT NULL then true
            when rmt.readon=''read'' or rmt.receivedon=''receive'' then true
            else false
        end
    ) as isread,  rmt.rmid as receiptmovementid
    from public.jet_process_receipt as r 
    inner join public.md_category as c on r.receiptcategoryid = c.categorydataid
    inner join public.jet_process_receiptmovement rmt on r.receiptid = rmt.receiptid 
        where rmt.rmid = (select max(rmid) from public.jet_process_receiptmovement where receiptid = r.receiptid AND pullbackremark IS NULL)
            and (rmt.movementtype = 1 OR rmt.movementtype=0) and r.attachstatus is null and r.currentstate != 3 ';
  
 
                
        _keyword := '''%'||keyword||'%''';
      _order :=_orderByType;
      IF (_start <0 OR _start IS NULL) THEN
          _offset:=0;
      ELSE
          _offset :=_start; 
      END IF;
      
      IF (_end <=0 OR _end IS NULL) THEN
              _limit :=4;
          ELSE
              _limit :=_end;
      END IF;   
      
      IF (orderByCol ='' OR orderByCol IS NULL) THEN
              _orderBy :='r.createDate';
          ELSE
              _orderBy :=orderByCol;
      END IF;
      IF (_orderbytype ='' OR _orderbytype IS NULL) THEN
              _order :='desc';
          ELSE
               _order :=_orderbytype;
      END IF;
     
      IF (_type ='Electronic') THEN
                nature :=' AND r.nature = ''Electronic'' ';
        END IF;
                      
                      IF (userpostid !=0 )THEN
                                             
                           _query := q1|| ' AND r.currentlywith='||userpostid || nature;
                          
                             if (keyword IS NOT NULL  ) THEN  
                                   _query := '';
                                   _query := q1|| ' AND r.currentlywith= '||userpostid|| nature ||'  AND (r.receiptnumber ilike '||_keyword ||' OR r.subject ilike '||_keyword ||')';
                        
                                   if (_orderby !='')  THEN 
                  
                                      _query := _query||' order by '||_orderby;
                                      if (_order !='')  THEN 

                                          _query := _query||' '||_order;
                                          if (_offset >=0)  THEN 

                                               _query := _query||' offset '||_offset;
                                              if (_limit >0)  THEN 
                                                  _query := _query||' limit '||_limit;

                                                 
                                               end if;
                                     
                                  
                                   end if;
                           
                               end if;
                          
                           end if;
                      
                           
                      end if;
                      
              end if;
        return query execute _query;
           
   end;
   

$BODY$;

ALTER FUNCTION public.get_put_in_file_list(text, bigint, text, integer, integer, text, text)
    OWNER TO postgres;


    
    
-----------------Get-file-inbox-list---------------------

CREATE OR REPLACE FUNCTION public.get_file_inbox_list(
	receiverid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(filemovementid bigint, filenumber character varying, subject character varying, sentby text, sentto text, senton timestamp without time zone, readon character varying, duedate timestamp without time zone, remark character varying, receivedon character varying, currentlywith bigint, nature character varying, fileid bigint, senderid bigint, currentstate integer, docfileid bigint, pullbackremark character varying, currentlywithusername text, hasnote boolean) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
    
    declare 
        
        _keyword text;
        _offset int;
        _limit int;
        _orderBy text;
        _order text;
        _query text;
    begin
      
      
   _query='SELECT fm.fmid as fileMovementId, f.filenumber as fileNumber ,f.subject as subject,
		(SELECT concat(up1.username,''('',  up1.postmarking,'')'',  up1.sectionname,'','', up1.departmentname)) as sentBy,
		(SELECT concat(up2.username, ''('',up2.postmarking,'')'', up2.sectionname,'','', up2.departmentname)) AS SentTo ,
		fm.createdate as sentOn, fm.readon as readOn, fm.duedate as dueDate, fm.remark as remark, fm.receivedon as receivedOn,
		f.currentlywith as currentlyWith, f.nature as nature, f.docfileid as fileId, fm.senderid as senderId , 
        f.currentstate as currentState , f.docfileid as docFileId , fm.pullbackremark as pullBackRemark , null as currentlywithusername , (case when n.content ='''' then false when n.content is null then false else true end )as hasNote
		FROM PUBLIC.jet_process_filemovement as fm 
        Join (select max(mov.fmid) as mfmId from PUBLIC.jet_process_filemovement mov where mov.active_ = true group by mov.fileId) fmov on fmov.mfmId = fm.fmid  
		JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
		JOIN PUBLIC.masterdata_userpost as up1 ON fm.senderid = up1.userpostid
		JOIN PUBLIC.masterdata_userpost as up2 ON fm.receiverid = up2.userpostid 
        left join public.jet_process_filenote as fn on fn.filemovementid=fm.fmid
         left join public.jet_process_note as n on n.noteid = fn.noteid';        
        _keyword := '''%'||keyword||'%''';
        _order :=_orderByType;
        IF (_start <0 OR _start IS NULL) THEN
            _offset:=0;
        ELSE
            _offset :=_start; 
        END IF;
        
        IF (_end <=0 OR _end IS NULL) THEN
                _limit :=4;
            ELSE
                _limit :=_end;
        END IF;   
        
        IF (orderByCol ='' OR orderByCol ='modifieddate' OR orderByCol ='modifiedDate' OR orderByCol IS NULL) THEN
                _orderBy :='fm.modifieddate';
           
        END IF;
        IF (orderByCol ='sentOn' OR orderByCol ='senton') THEN
                _orderBy :='fm.createdate';
           
        END IF;
        
        IF (orderByCol ='dueDate' OR orderByCol ='duedate') THEN
                _orderBy :='fm.duedate';
           
        END IF;
         
        IF (orderByCol ='filenumber' OR orderByCol ='fileNumber' ) THEN
                _orderBy :='f.filenumber';
           
        END IF;
        IF (orderByCol ='subject' ) THEN
                _orderBy :='f.subject';
           
        END IF;
         IF (_orderByType ='' OR _orderByType IS NULL) THEN
                _order :='desc';
            ELSE
                _order :=_orderByType;
        END IF;
                        IF (receiverid !=0 )THEN
                        
                             _query := _query|| ' where fm.receiverid ='||receiverid;
                            
                               if (keyword IS NOT NULL) THEN
                
                                     _query := _query||' AND (filenumber ilike '||_keyword ||' OR subject ilike '||_keyword ||')';
                          
                                     if (_orderby !='')  THEN 
                    
                                        _query := _query||' order by '||_orderby;
                                        if (_order !='')  THEN 

                                                _query := _query||' '||_order;
                                                if (_offset >=0)  THEN 

                                                         _query := _query||' offset '||_offset;
                                                        if (_limit >0)  THEN 
                                                            _query := _query||' limit '||_limit;

                                                         end if;

                                                end if;
                                                
                                           end if;
                                           
                                    end if;
                                    
                             end if;
                             
                end if;
                
          return query execute _query;
             
     end;
     
 
$BODY$;

ALTER FUNCTION public.get_file_inbox_list(bigint, text, integer, integer, text, text)
    OWNER TO postgres;
   
    
-----------------------Get-File-Sent-List------------------------------

CREATE OR REPLACE FUNCTION public.get_file_sent_list(
	_senderid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(filemovementid bigint, filenumber character varying, subject character varying, sentby text, sentto text, senton timestamp without time zone, readon character varying, duedate timestamp without time zone, remark text, receivedon character varying, currentlywith bigint, nature character varying, fileid bigint, senderid integer, currentstate integer, docfileid bigint, pullbackremark character varying, currentlywithusername text) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
    
    declare 
        
        _keyword text;
        _offset int;
        _limit int;
        _orderBy text;
        _order text;
        _query text;
    begin
      
      
   _query=' SELECT fm.fmid as fileMovementId, f.filenumber , f.subject ,
			null as sendBy, (SELECT concat(up1.username, ''('',up1.postmarking ,'')'',
            up1.sectionname,'','' , up1.departmentname)) AS sentTo ,
			fm.createdate as SentOn, fm.readon as readOn, fm.duedate ,
            null as remark, fm.receivedon as receivedOn , f.currentlywith as currentlyWith ,
            f.nature as nature , f.docfileid as fileId , 0 as senderid , f.currentstate as 
            currentState ,
            f.docfileid as docFileId , fm.pullbackremark as pullBackRemark ,  (SELECT concat(up2.username, ''('',up2.postmarking ,'')'',
            up2.sectionname,'','' , up2.departmentname)) as currentlywithusername
			FROM PUBLIC.jet_process_filemovement as fm 
			JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
			JOIN PUBLIC.masterdata_userpost as up1 ON fm.receiverid = up1.userpostid 
            JOIN PUBLIC.masterdata_userpost as up2 ON f.currentlywith = up2.userpostid 
			where currentstate = 2  AND fm.active_ = true';
                  
        _keyword := '''%'||keyword||'%''';
        _order :=_orderByType;
        IF (_start <0 OR _start IS NULL) THEN
            _offset:=0;
        ELSE
            _offset :=_start; 
        END IF;
        
        IF (_end <=0 OR _end IS NULL) THEN
                _limit :=4;
            ELSE
                _limit :=_end;
        END IF;   
        
        IF (orderByCol ='' OR orderByCol ='sentOn' OR orderByCol ='senton' OR orderByCol IS NULL) THEN
                _orderBy :='fm.createdate';
           
        END IF;
        IF ( orderByCol ='filenumber' OR orderByCol ='fileNumber') THEN
                _orderBy :='f.filenumber';
           
        END IF;
        IF ( orderByCol ='subject') THEN
                _orderBy :='f.subject';
           
        END IF;
         IF ( orderByCol ='duedate' OR orderByCol ='dueDate') THEN
                _orderBy :='fm.duedate';
           
        END IF;
         IF (_orderByType ='' OR _orderByType IS NULL) THEN
                _order :='desc';
            ELSE
                _order :=_orderByType;
        END IF;
       
                        
                        IF (_senderid !=0 )THEN
                        
                             _query := _query|| ' AND fm.senderid ='||_senderid;
                            
                               IF (keyword IS NOT NULL) THEN  
                                                                
                                     _query := _query||' AND (f.filenumber ilike '||_keyword ||' OR f.subject ilike '||_keyword ||')';
                          
                                     IF (_orderby !='')  THEN 
                    
                                        _query := _query||' order by '||_orderby;
                                        IF (_order !='')  THEN 

                                            _query := _query||' '||_order;
                                            IF (_offset >=0)  THEN 

                                                 _query := _query||' offset '||_offset;
                                                IF (_limit >0)  THEN 
                                                    _query := _query||' limit '||_limit;

                                                 END IF;
                                        
                                             END IF;
                                
                                           END IF;
                            
                                    END IF;
                        
                                 END IF;
                        
                            END IF;
         
              return query execute _query;
     END;
     
 
$BODY$;

ALTER FUNCTION public.get_file_sent_list(bigint, text, integer, integer, text, text)
    OWNER TO postgres;
 
    
------------------------------Get-File-Movement-List----------------------------

CREATE OR REPLACE FUNCTION public.get_file_movement_list(
	_filemovementid bigint,
	_fileid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(filemovementid bigint, filenumber text, subject text, sentby text, sentto text, senton timestamp without time zone, readon text, duedate text, remark character varying, receivedon text, currentlywith integer, nature text, fileid integer, senderid integer, currentstate integer, docfileid bigint, pullbackremark character varying, currentlywithusername text) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
    
    declare 
        
        _keyword text;
        _offset int;
        _limit int;
        _orderBy text;
        _order text;
        _query text;
    begin
      
      
   _query='SELECT 
	fm.fmid as fileMovementId, 
	null as filenumber , 
	null as subject ,
	(SELECT concat(up2.username, ''('',up2.postmarking,'')'', up2.sectionname,'','', up2.departmentname)) as sentBy ,
	(SELECT concat(up1.username, ''('',up1.postmarking,'')'', up1.sectionname,'','', up1.departmentname)) AS sentTo ,
	fm.createdate as sentOn, null as readOn, null as dueDate , fm.remark as remark, null as receivedOn , 0 as currentlyWith, 
    null as nature, 0 as fileId, 0 as senderId , f.currentstate as currentState , f.docfileid as docFileId , fm.pullbackremark as pullBackRemark , null as currentlywithusername
	FROM PUBLIC.jet_process_filemovement as fm 
	left outer JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
	left outer JOIN PUBLIC.masterdata_userpost as up1 ON fm.receiverid = up1.userpostid
	left outer JOIN PUBLIC.masterdata_userpost as up2 ON fm.senderid = up2.userpostid WHERE fm.movementtype != 0 AND fm.active_ = true
    ';
                  
        _keyword := '''%'||keyword||'%''';
        _order :=_orderByType;
        IF (_start <0 OR _start IS NULL) THEN
            _offset:=0;
        ELSE
            _offset :=_start; 
        END IF;
        
        IF (_end <=0 OR _end IS NULL) THEN
                _limit :=4;
            ELSE
                _limit :=_end;
        END IF;   
        
        IF (orderByCol ='' OR orderByCol IS NULL) THEN
                _orderBy :='fm.createdate';
            ELSE
                _orderBy :='f.'||orderByCol;
        END IF;
         IF (_orderByType ='' OR _orderByType IS NULL) THEN
                _order :='desc';
            ELSE
                _order :=_orderByType;
        END IF;
       
                        
                        IF (_fileId !=0 )THEN
                        
                             _query := _query|| 'AND fm.fileId ='||_fileId;
                                _query := _query|| 'AND fm.fmid <='||_filemovementid;

                               if (keyword IS NOT NULL) THEN  
                                                                
--                                      _query := _query||' AND (f.filenumber ilike '||_keyword ||' OR f.subject ilike '||_keyword ||')';
                          
                                     if (_orderby !='')  THEN 
                    
                                        _query := _query||' order by '||_orderby;
                                        if (_order !='')  THEN 

                                            _query := _query||' '||_order;
                                            if (_offset >=0)  THEN 

                                                 _query := _query||' offset '||_offset;
                                                if (_limit >0)  THEN 
                                                    _query := _query||' limit '||_limit;

                                                 end if;
                                        

                                             end if;

                                         end if;

                                     end if;
                        
                             
                             end if;
                             
                    end if;
                 
                return query execute _query;
       
     end;
     
 
$BODY$;

ALTER FUNCTION public.get_file_movement_list(bigint, bigint, text, integer, integer, text, text)
    OWNER TO postgres;
 

------------------------Get-Receipt-Movement-List---------------------

CREATE OR REPLACE FUNCTION public.get_receipt_movement_list(
	_receiptmovementid bigint,
	_receiptid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(receiptmovementid bigint, receiptnumber text, subject text, sender text, sentby text, sentto text, senton timestamp without time zone, readon text, duedate text, remark character varying, receivedon text, nature text, receiptid integer, pullbackremark character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
    
    declare 
        
        _keyword text;
        _offset int;
        _limit int;
        _orderBy text;
        _order text;
        _query text;
    begin
      
      
   _query=' SELECT 
	rmid as receiptMovementId, 
	null as receiptnumber ,null as subject , null as sender ,
	(SELECT concat(up2.username ,'' ('', up2.postmarking ,'') '', up2.sectionname ,'' , '', up2.departmentname)) as sentBy ,
	(SELECT concat(up1.username ,'' ('', up1.postmarking,'') '', up1.sectionname ,'' , '', up1.departmentname)) as sentTo,
	rm.createdate as sentOn, null as readOn , null as duedate , remark as remark, null as receivedOn,
    null as nature, 0 as receiptId , rm.pullBackRemark as pullBackRemark
	FROM PUBLIC.jet_process_receiptmovement as rm 
	left outer JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
    left outer JOIN PUBLIC.masterdata_userpost as up1 ON rm.receiverid = up1.userpostid 
	left outer JOIN PUBLIC.masterdata_userpost as up2 ON rm.senderid = up2.userpostid WHERE movementtype != 0 AND active_ = true
    ';
                  
        _keyword := '''%'||keyword||'%''';
        
        IF (_start <0 OR _start IS NULL) THEN
            _offset:=0;
        ELSE
            _offset :=_start; 
        END IF;
        
        IF (_end <=0 OR _end IS NULL) THEN
                _limit :=4;
            ELSE
                _limit :=_end;
        END IF;   
        
        IF (orderByCol ='' OR orderByCol IS NULL) THEN
                _orderBy :='rm.createdate';
            ELSE
                _orderBy :='r.'||orderByCol;
        END IF;
         IF (_orderByType ='' OR _orderByType IS NULL) THEN
                _order :='desc';
            ELSE
                _order :=_orderByType;
        END IF;
       
                        IF (_receiptid !=0 )THEN
                        
                             _query := _query|| 'AND rm.receiptid ='||_receiptid;
                              _query := _query|| ' AND rm.rmid <='||_receiptMovementId;
                            
                               if (keyword IS NOT NULL) THEN  
                                                                
--                                      _query := _query||' AND (f.filenumber ilike '||_keyword ||' OR f.subject ilike '||_keyword ||')';
                          
                                     if (_orderby !='')  THEN 
                    
                                         _query := _query||' order by '||_orderby;
                                        if (_order !='')  THEN 

                                            _query := _query||' '||_order;
                                            if (_offset >=0)  THEN 

                                                 _query := _query||' offset '||_offset;
                                                if (_limit >0)  THEN 
                                                    _query := _query||' limit '||_limit;

                                                 end if;
                                         
                                             end if;

                                         end if;

                                     end if;
                        
                             end if;
                        
                    end if;
                     return query execute _query;
                    
     end;
     
 
$BODY$;

ALTER FUNCTION public.get_receipt_movement_list(bigint, bigint, text, integer, integer, text, text)
    OWNER TO postgres;


    
        
    
         --    ----------------------------------------  Get Receipt List  ---------------------------------------

    
    CREATE OR REPLACE FUNCTION public.get_receipt_created_list(
	post_id bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(receiptmovementid bigint , receiptid bigint, receiptnumber character varying, subject character varying, category character varying, createdate timestamp without time zone, remark character varying, viewpdfurl character varying, nature character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
    
    declare 
        
        _keyword text;
        _offset int;
        _limit int;
        _orderBy text;
        _order text;
        _query text;
    begin
    _query:='SELECT  rm.rmid as receiptmovementid ,   r.receiptid as receiptId , r.receiptnumber as receiptnumber , 
    r.subject as subject , categoryvalue as category , r.createDate as createDate ,  
    r.remarks as remark , r.viewpdfurl AS viewpdfurl ,
	nature AS nature FROM PUBLIC.jet_process_receipt r INNER JOIN 
	PUBLIC.md_category  ON categorydataid = receiptcategoryid  
    INNER JOIN public.jet_process_receiptmovement as rm ON rm.receiptid= r.receiptid where rm.movementtype=0 AND currentstate = 1  AND attachstatus IS NULL ';
    
        _keyword := '''%'||keyword||'%''';
        IF (_start <0 OR _start IS NULL) THEN
            _offset:=0;
        ELSE
            _offset :=_start; 
        END IF;
        
        IF (_end <=0 OR _end IS NULL) THEN
                _limit :=4;
            ELSE
                _limit :=_end;
        END IF;   
        IF (orderbycol ='' OR orderbycol ='modifieddate' OR orderbycol ='modifiedDate' OR orderbycol IS NULL) THEN
                _orderBy :='r.modifieddate';
        END IF;
        IF ( orderbycol ='createdon' OR orderbycol ='createdOn' OR orderbycol='createDate' OR orderbycol='createdate') THEN
                _orderBy :='r.createdate';
        END IF;
         IF (orderbycol ='receiptnumber' OR orderbycol ='receiptNumber') THEN
                _orderBy :='r.receiptnumber';
        END IF;
         IF (orderbycol ='subject') THEN
                _orderBy :='r.subject';
        END IF;
        
          IF (_orderByType ='' OR _orderByType IS NULL) THEN
                _order :='desc';
            ELSE
                _order :=_orderbytype;
        END IF;
       
                        
                        IF (post_id !=0) THEN
                        
                             _query := _query|| ' AND userpostid ='||post_id;
                            
                               if (keyword IS NOT NULL) THEN
                                     _query := _query||  'AND (receiptnumber ilike'|| _keyword ||'OR subject ilike'|| _keyword ||'OR  categoryvalue ilike'|| _keyword ||')';
                          
                                     if (_orderBy !='')  THEN 
                    
                                        _query := _query||' order by '||_orderBy;
                                        if (_order !='')  THEN 

                                            _query := _query||' '||_order;
                                            if( _offset >=0)  THEN 

                                                 _query := _query||' offset '||_offset;
                                                if (_limit >0)  THEN 
                                                    _query := _query||' limit '||_limit;

                                                    
                                                 end if;
                                    
                                             end if;

                                         end if;

                                     end if;

                                   end if;

                                end if;                        
       return query execute _query;
        
        END;
$BODY$;

ALTER FUNCTION public.get_receipt_created_list(bigint, text, integer, integer, text, text)
    OWNER TO postgres;
    
    
    
    
    --    ------------------------------------- Get Receipt Inbox List  -------------------------------------------

 -- FUNCTION: public.get_receipt_inbox_list(bigint, text, integer, integer, text, text)

-- DROP FUNCTION IF EXISTS public.get_receipt_inbox_list(bigint, text, integer, integer, text, text);

CREATE OR REPLACE FUNCTION public.get_receipt_inbox_list(
	receiverid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(senderid bigint, receiptmovementid bigint, receiptnumber character varying, subject character varying, sender text, sentby text, sentto text, senton timestamp without time zone, readon character varying, duedate timestamp without time zone, remark character varying, receiveon character varying, nature character varying, receiptid bigint, pullbackremark character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
    
    declare 
        
        _keyword text;
        _offset int;
        _limit int;
        _orderBy text;
        _order text;
        _query text;
    begin
      
      
   
      
   _query='   SELECT
                rm.senderid AS senderid,
                rm.rmid AS receiptMovementId,
                r.receiptnumber AS receiptNumber,
                r.subject AS subject,	
                null as sender,	
                (SELECT concat(up1.username,  '' ('',up1.postmarking,'') '', up1.sectionname ,'' , '', up1.departmentname)) as sentBy,
                null AS sentTo ,	
                rm.createdate AS sentOn,	
                rm.readon AS readOn,
                rm.duedate AS dueDate,	
                rm.remark AS remark,	
                rm.receivedon as receiveOn,	
                r.nature as nature,
                r.receiptid as receiptId,
                rm.pullbackremark as pullBackRemark
                FROM PUBLIC.jet_process_receiptmovement as rm 

                Join (select max(mov.rmid) as mreceiptId from PUBLIC.jet_process_receiptmovement mov where mov.active_ = true AND movementtype !=2 group by mov.receiptId) rmov on rmov.mreceiptId = rm.rmid  

                JOIN PUBLIC.jet_process_receipt AS r ON rm.receiptId = r.receiptId
                JOIN PUBLIC.masterdata_userpost as up1 ON rm.senderid = up1.userpostid
                JOIN PUBLIC.masterdata_userpost as up2 ON rm.receiverid = up2.userpostid 
                where  r.attachstatus is null';
                  
        _keyword := '''%'||keyword||'%''';
        
        IF (_start <0 OR _start IS NULL) THEN
            _offset:=0;
        ELSE
            _offset :=_start; 
        END IF;
        
        IF (_end <=0 OR _end IS NULL) THEN
                _limit :=4;
            ELSE
                _limit :=_end;
        END IF;   
        
       
         IF (orderByCol ='' OR orderByCol ='modifieddate' OR orderByCol ='modifiedDate' OR orderByCol IS NULL) THEN
                _orderBy :='rm.modifieddate';
           
        END IF;
         
        IF (orderByCol ='receiptnumber' OR orderByCol ='receiptNumber' ) THEN
                _orderBy :='r.receiptnumber';
           
        END IF;
        IF (orderByCol ='subject' ) THEN
                _orderBy :='r.subject';
           
        END IF;
         IF (orderByCol ='dueon' OR orderByCol ='dueOn' ) THEN
                _orderBy :='rm.duedate';
           
        END IF;
         IF (orderByCol ='senton' OR orderByCol ='sentOn' ) THEN
                _orderBy :='rm.createdate';
           
        END IF;
         IF (_orderByType ='' OR _orderByType IS NULL) THEN
                _order :='desc';
            ELSE
                _order :=_orderByType;
        END IF;
       
                        
                        IF (receiverid !=0 )THEN
                        
                             _query := _query|| '  AND rm.receiverid  ='||receiverid;
                            
                               IF (keyword IS NOT NULL) THEN
                                     _query := _query||' AND (r.receiptnumber ilike '||_keyword ||' OR r.subject ilike '||_keyword ||')';
                          
                                     IF (_orderby !='')  THEN 
                    
                                        _query := _query||' order by '||_orderby;
                                        IF (_order !='')  THEN 

                                            _query := _query||' '||_order;
                                            IF (_offset >=0)  THEN 

                                                 _query := _query||' offset '||_offset;
                                                IF (_limit >0)  THEN 
                                                    _query := _query||' limit '||_limit;

                                                 END IF;
                                        
                                          END IF;

                                      END IF;

                                  END IF;

                               END IF;
    
                        END IF;
         
             return query execute _query;
     END;
     
 
$BODY$;

ALTER FUNCTION public.get_receipt_inbox_list(bigint, text, integer, integer, text, text)
    OWNER TO postgres;

    
--    ------------------------------------- Get Receipt Sent List  -------------------------------------------

CREATE OR REPLACE FUNCTION public.get_receipt_sent_list(
	_senderid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(receiptmovementid bigint, receiptnumber character varying, subject character varying, sender character varying, sentby text, sentto text, senton timestamp without time zone, readon character varying, duedate timestamp without time zone, remark character varying, receivedon character varying, nature character varying, receiptid bigint, pullbackremark character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
    
    declare 
        
        _keyword text;
        _offset int;
        _limit int;
        _orderBy text;
        _order text;
        _query text;
    begin
      
      
   _query=' SELECT rm.rmid as receiptMovementId, r.receiptNumber as receiptNumber ,r.subject as subject , r.name as sender ,
		null as sentBy,
		(SELECT concat(up.username, '' ('',up.postmarking,'') '', up.sectionname,'' , '', up.departmentname)) as sentTo ,
		rm.createdate as sentOn, rm.readOn as readOn , rm.dueDate as dueDate , rm.remark as remark ,
        rm.receivedOn as receivedOn, r.nature as nature ,r.receiptid as receiptid , pullBackRemark as pullBackRemark
		FROM PUBLIC.jet_process_receiptmovement as rm 
		JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
		JOIN PUBLIC.masterdata_userpost as up ON rm.receiverid = up.userpostid
        where rm.active_ = true and rm.pullbackremark is null and rm.movementtype = 1 ';
                  
        _keyword := '''%'||keyword||'%''';
        
        IF (_start <0 OR _start IS NULL) THEN
            _offset:=0;
        ELSE
            _offset :=_start; 
        END IF;
        
        IF (_end <=0 OR _end IS NULL) THEN
                _limit :=4;
            ELSE
                _limit :=_end;
        END IF;   
        
        IF (orderByCol ='' OR orderByCol ='senton' OR orderByCol ='sentOn' OR orderByCol IS NULL) THEN
                _orderBy :='rm.createdate';
           
        END IF;
         IF (orderByCol ='duedate' OR orderByCol ='dueDate') THEN
                _orderBy :='rm.createdate';
           
        END IF;
         IF (orderByCol ='receiptnumber' OR orderByCol ='receiptNumber') THEN
                _orderBy :='r.receiptnumber';
           
        END IF;
         IF (orderByCol ='subject') THEN
                _orderBy :='r.subject';
           
        END IF;
        
        IF (_orderbytype ='' OR _orderbytype IS NULL) THEN
                _order :='desc';
            ELSE
                 _order :=_orderbytype;
        END IF;
       
                        
                        IF (_senderid !=0 )THEN
                        
                             _query := _query|| ' AND rm.senderid  ='||_senderid;
                            
                               IF (keyword IS NOT NULL) THEN  
                                                                
                                     _query := _query||' AND (r.receiptnumber ilike '||_keyword ||' OR r.subject ilike '||_keyword ||')';
                          
                                     IF (_orderby !='')  THEN 
                    
                                        _query := _query||' order by '||_orderby;
                                        IF (_order !='')  THEN 

                                            _query := _query||' '||_order;
                                            IF (_offset >=0)  THEN 

                                                 _query := _query||' offset '||_offset;
                                                IF (_limit >0)  THEN 
                                                    _query := _query||' limit '||_limit;

                                                  END IF;
                                    
                                              END IF;

                                          END IF;

                                     END IF;
                        
                              END IF;
                        
                         END IF;
                     return query execute _query;
        
     end;
     
 
$BODY$;

ALTER FUNCTION public.get_receipt_sent_list(bigint, text, integer, integer, text, text)
    OWNER TO postgres;
  
    
----------------------file corr receipt list---------------------------

CREATE OR REPLACE FUNCTION public.get_file_correspondence_list(
	_viewmode text,
	_filemovementid bigint,
	_fileid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(receiptid bigint, receiptnumber character varying, subject character varying, category text, createdate timestamp without time zone, remark character varying, viewpdfurl text, nature character varying, correspondencetype character varying, receiptmovementid bigint, isdetachable boolean) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
    
    declare 
        viewmode text;
        _keyword text;
        _offset int;
        _limit int;
        _orderBy text;
        _order text;
        _query text;
    begin
      
      
   _query='
 SELECT r.receiptid as receiptId, r.receiptnumber, r.subject,  null as category, fc.createDate, fc.remarks  as remark , null as viewpdfurl,
 	r.nature, fc.correspondenceType as correspondenceType, fc.receiptmovementid as receiptmovementid, 
 (
        case
            when fc.filemovementId='||_filemovementid|| 'then true
            else false
        end
    ) as isdetachable

    FROM PUBLIC.jet_process_receipt r INNER JOIN 
 PUBLIC.jet_process_filecorrreceipt as fc  ON r.receiptid = fc.receiptid AND fc.detachremark IS NULL';
                  
        _keyword := '''%'||keyword||'%''';
        
        IF (_start <0 OR _start IS NULL) THEN
            _offset:=0;
        ELSE
            _offset :=_start; 
        END IF;
        
        IF (_end <=0 OR _end IS NULL) THEN
                _limit :=4;
            ELSE
                _limit :=_end;
        END IF;   
        
        IF (orderByCol ='' OR orderByCol ='attachOn' OR orderByCol ='modifiedDate' OR orderByCol IS NULL) THEN
                _orderBy :='fc.createdate';
        END IF;
         IF ( orderByCol ='receiptNo' OR orderByCol ='receiptno' OR orderByCol ='receiptnumber' ) THEN
                _orderBy :='r.receiptnumber';
        END IF;
         IF (_orderByType ='' OR _orderByType IS NULL) THEN
                _order :='desc';
            ELSE
                _order :=_orderByType;
        END IF; 
        IF (_viewmode ='ViewModeFromSentFile') THEN
                viewmode :='<';
        END IF;
        IF (_viewmode ='' OR _viewmode IS NULL) THEN
                viewmode :='<=';
        END IF;
       
                        
                        IF (_fileId !=0 )THEN
                        
                             _query := _query|| ' where fc.docfileid ='||_fileId;
                             _query := _query|| ' AND fc.filemovementId '||viewmode||_filemovementid;
                            
                               if (keyword IS NOT NULL) THEN  
                                                                
--                                      _query := _query||' AND (f.filenumber ilike '||_keyword ||' OR f.subject ilike '||_keyword ||')';
                          
                                     if (_orderby !='')  THEN 
                    
                                        _query := _query||' order by '||_orderby;
                                        if (_order !='')  THEN 

                                            _query := _query||' '||_order;
                                            if (_offset >=0)  THEN 

                                                 _query := _query||' offset '||_offset;
                                                if (_limit >0)  THEN 
                                                    _query := _query||' limit '||_limit;

                                                 end if;
                                        

                                             end if;

                                         end if;

                                     end if;
                        
                             
                             end if;
                             
                    end if;
                 
                return query execute _query;
       
     end;
     
 
$BODY$;

ALTER FUNCTION public.get_file_correspondence_list(text, bigint, bigint, text, integer, integer, text, text)
    OWNER TO postgres;
    
---------------------note list---------------------    
CREATE OR REPLACE FUNCTION public.get_all_attached_note_list(
    _viewmode text,
	_filemovementid bigint,
	_fileid bigint)
    RETURNS TABLE(noteid bigint, signature character varying, createdate timestamp without time zone, content text) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
    
	declare 
       _query text;
       viewmode text;
   
    begin
    _query :='SELECT n.noteid, n.signature, n.modifieddate ,n."content" from PUBLIC.jet_process_note n LEFT join PUBLIC.jet_process_filenote
					fn on n.noteid = fn.noteid';
                    
         IF (_viewmode ='ViewModeFromSentFile') THEN
                viewmode :='<';
        END IF;
        IF (_viewmode ='' OR _viewmode IS NULL) THEN
                viewmode :='<';
        END IF;      
                    
                    
       IF (_fileid !=0  )THEN
           _query=_query|| ' where fn.fileid ='||_fileid||' AND fn.filemovementid'||viewmode||_filemovementid;
                return query execute _query;
       			END IF;
     end;
$BODY$;

ALTER FUNCTION public.get_all_attached_note_list(text,bigint, bigint)
    OWNER TO postgres;

------------------ attach receipt movement--------------------

CREATE OR REPLACE FUNCTION public.get_attach_receipt_movement_list(
	_receiptid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(receiptmovementid bigint, receiptnumber text, subject text, sender text, sentby text, sentto text, senton timestamp without time zone, readon text, duedate text, remark character varying, receivedon text, nature text, receiptid integer, pullbackremark character varying) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
    
    declare 
        
        _keyword text;
        _offset int;
        _limit int;
        _orderBy text;
        _order text;
        _query text;
    begin
      
      
   _query=' SELECT 
	rmid as receiptMovementId, 
	null as receiptnumber ,null as subject , null as sender ,
	(SELECT concat(up2.username ,'' ('', up2.postmarking ,'') '', up2.sectionname ,'' , '', up2.departmentname)) as sentBy ,
	(SELECT concat(up1.username ,'' ('', up1.postmarking,'') '', up1.sectionname ,'' , '', up1.departmentname)) as sentTo,
	rm.createdate as sentOn, null as readOn , null as duedate , remark as remark, null as receivedOn,
    null as nature, 0 as receiptId , rm.pullBackRemark as pullBackRemark
	FROM PUBLIC.jet_process_receiptmovement as rm 
	left outer JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
    left outer JOIN PUBLIC.masterdata_userpost as up1 ON rm.receiverid = up1.userpostid 
	left outer JOIN PUBLIC.masterdata_userpost as up2 ON rm.senderid = up2.userpostid WHERE movementtype != 0 AND active_ = true 
    ';
                  
        _keyword := '''%'||keyword||'%''';
        
        IF (_start <0 OR _start IS NULL) THEN
            _offset:=0;
        ELSE
            _offset :=_start; 
        END IF;
        
        IF (_end <=0 OR _end IS NULL) THEN
                _limit :=4;
            ELSE
                _limit :=_end;
        END IF;   
        
        IF (orderByCol ='' OR orderByCol IS NULL) THEN
                _orderBy :='rm.createdate';
            ELSE
                _orderBy :='r.'||orderByCol;
        END IF;
         IF (_orderByType ='' OR _orderByType IS NULL) THEN
                _order :='desc';
            ELSE
                _order :=_orderByType;
        END IF;
       
                        IF (_receiptid !=0 )THEN
                        
                             _query := _query|| 'AND rm.receiptid ='||_receiptid;
                             
                            
                               if (keyword IS NOT NULL) THEN  
                                                                
--                                      _query := _query||' AND (f.filenumber ilike '||_keyword ||' OR f.subject ilike '||_keyword ||')';
                          
                                     if (_orderby !='')  THEN 
                    
                                         _query := _query||' order by '||_orderby;
                                        if (_order !='')  THEN 

                                            _query := _query||' '||_order;
                                            if (_offset >=0)  THEN 

                                                 _query := _query||' offset '||_offset;
                                                if (_limit >0)  THEN 
                                                    _query := _query||' limit '||_limit;

                                                 end if;
                                         
                                             end if;

                                         end if;

                                     end if;
                        
                             end if;
                        
                    end if;
                     return query execute _query;
                    
     end;
     
 
$BODY$;

ALTER FUNCTION public.get_attach_receipt_movement_list(bigint, text, integer, integer, text, text)
    OWNER TO postgres;

 
 ------------------------closed-receipt-list-----------------------------   
    
CREATE OR REPLACE FUNCTION public.get_closed_receipt_list(
	closedby bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	orderbytype text)
    RETURNS TABLE(receiptclosedid bigint, nature character varying, receiptnumber character varying, subject character varying, closedon timestamp without time zone, closingremarks character varying, receiptid bigint) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
declare 
    _closedby bigint;
    _keyword text;
    _offset int;
    _limit int;
    _orderby text;
    _order text;
    _query text;
begin
    _closedby := closedby;
    _query := 'SELECT cr.receiptclosedid as receiptclosedid, r.nature as nature , 
                r.receiptNumber as receiptNumber,r.subject as subject , cr.createdate as closedon ,
                cr.closingremarks as closingremarks, cr.receiptid as receiptid
                FROM PUBLIC.jet_process_receiptclosedetail as cr 
                JOIN PUBLIC.jet_process_receipt AS r ON cr.receiptId = r.receiptId ';
                
     _keyword := '''%' || keyword || '%''';
     IF (_start <0 OR _start IS NULL) THEN
        _offset := 0;
     ELSE 
        _offset := _start;
     END IF;
     
     IF(_end <= 0 OR _end IS NULL) THEN
        _limit := 4;
     ELSE
        _limit := _end;
     END IF;
     
     IF (orderbycol = '' OR orderbycol = 'closedOn' OR orderbycol = 'closedon' OR orderbycol = 'createDate' OR orderbycol = 'createdate') THEN
        _orderBy := ' cr.createdate ';
     END IF;
     
      IF (orderbycol = 'receiptnumber' OR orderbycol = 'createDate' OR orderbycol = 'receiptNumber') THEN
        _orderBy := ' r.receiptnumber ';
     END IF;
     
     IF(orderByType ='' or orderByType IS NULL) THEN
        _order := ' desc ';
     ELSE 
        _order := orderbytype;
     END IF;
    
    IF(_closedby !=0) THEN
        _query := _query ||'where closedby = ' || _closedby;
        
        IF (_keyword IS NOT NULL) THEN 
            _query := _query || 'AND (receiptnumber ilike ' || _keyword || 'OR subject ilike ' || _keyword || ')';
            
            if(_orderBy != '') THEN
                _query := _query || ' order by ' || _orderBy;
                
                if(_order != '') THEN
                    _query := _query || '' || _order;
                
                    if(_offset >= 0 ) THEN
                        _query := _query || ' offset ' || _offset;
                        
                        if(_limit > 0 ) THEN 
                            _query := _query || ' limit ' || _limit;
                            
                        END IF;
                    
                    END IF;
                    
                END IF;
            
            END IF;
            
        END IF;
   
   END IF;
  
  return query execute _query;

end;

$BODY$;

ALTER FUNCTION public.get_closed_receipt_list(bigint, text, integer, integer, text, text)
    OWNER TO postgres;
    
    ---------------------------------get_receipt_attached_existing_file------------------

CREATE OR REPLACE FUNCTION public.get_receipt_attach_in_file_list(
	_type text,
	userpostid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(docfileid bigint, filenumber character varying, subject character varying, category character varying, createdate timestamp without time zone, remark character varying, nature character varying, isread boolean, filemovementid bigint) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
  
  declare 
      nature text;
      _keyword text;
      _offset int;
      _limit int;
      _orderBy text;
      _order text;
      _query text;
      q1 text;
      q2 text;
      q3 text;
  begin
    nature :='';
 q1='select f.docfileid as docfileid, f.filenumber as filenumber, f.subject as subject, c.categoryvalue as category, f.createDate as createdate, f.remarks as remark,  f.nature as nature,
     
    (
        case
            when fmt.movementtype=0 then true
            when fmt.pullbackremark IS NOT NULL then true
            when fmt.readon=''read'' or fmt.receivedon=''receive'' then true
            else false
        end
    ) as isread,  fmt.fmid as filemovementid
    from public.jet_process_docfile as f 
    inner join public.md_category as c on f.categoryid = c.categorydataid
    inner join public.jet_process_filemovement fmt on f.docfileid = fmt.fileid 
        where fmt.fmid = (select max(fmid) from public.jet_process_filemovement where fileid = f.docfileid AND pullbackremark is null)
            and (fmt.movementtype = 1 OR fmt.movementtype=0)';
  
 
                
        _keyword := '''%'||keyword||'%''';
      _order :=_orderByType;
      IF (_start <0 OR _start IS NULL) THEN
          _offset:=0;
      ELSE
          _offset :=_start; 
      END IF;
      
      IF (_end <=0 OR _end IS NULL) THEN
              _limit :=4;
          ELSE
              _limit :=_end;
      END IF;   
      
      IF (orderByCol ='' OR orderByCol IS NULL) THEN
              _orderBy :='f.createDate';
          ELSE
              _orderBy :=orderByCol;
      END IF;
      IF (_orderbytype ='' OR _orderbytype IS NULL) THEN
              _order :='desc';
          ELSE
               _order :=_orderbytype;
      END IF;
      
       IF (_type ='Physical') THEN
                nature :=' AND f.nature = ''Physical'' ';
        END IF;
       
     
                      
                      IF (userpostid !=0 )THEN
                                             
                           _query := q1|| ' AND f.currentlywith='||userpostid || nature;
                          
                             if (keyword IS NOT NULL  ) THEN  
                                   _query := '' ;
                                   _query := q1|| ' AND f.currentlywith= '||userpostid || nature || ' AND (f.filenumber ilike '||_keyword ||' OR f.subject ilike '||_keyword ||')';
                        
                                   if (_orderby !='')  THEN 
                  
                                      _query := _query||' order by '||_orderby;
                                      if (_order !='')  THEN 

                                          _query := _query||' '||_order;
                                          if (_offset >=0)  THEN 

                                               _query := _query||' offset '||_offset;
                                              if (_limit >0)  THEN 
                                                  _query := _query||' limit '||_limit;

                                                 
                                               end if;
                                     
                                  
                                   end if;
                           
                               end if;
                          
                           end if;
                      
                           
                      end if;
                      
              end if;
              
        return query execute _query;
           
   end;
   

$BODY$;

ALTER FUNCTION public.get_receipt_attach_in_file_list(text, bigint, text, integer, integer, text, text)
    OWNER TO postgres;



 
    
    
--    ************************************************** All Count ****************************** 

-- ------------------- Get-file-created-list-count ----------------------------
CREATE OR REPLACE FUNCTION public.get_file_created_list_count(
	post_id bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
DECLARE total BIGINT;
    _query text;
    _keyword text;
BEGIN
    total :=0;
    _keyword := '''%'||keyword||'%''';
    _query :='Select  count(*)  FROM public.jet_process_docfile  
            INNER JOIN public.md_category  
            ON categorydataid = categoryid 
            where currentstate = 1 AND userpostid ='|| post_id;
        IF post_id !=0 AND post_id IS NOT NULL THEN 
            
            
            IF  keyword IS NOT NULL  THEN
            EXECUTE _query ||' AND (filenumber ilike'|| _keyword  ||'OR subject ilike'|| _keyword ||' OR  categoryvalue ilike'|| _keyword || ')' INTO total ;       
            return total;
            END IF;
             EXECUTE _query INTO total;
            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_file_created_list_count(bigint, text)
    OWNER TO postgres;

    
---------------------Get-File-Inbox-List-count-----------------------------

CREATE OR REPLACE FUNCTION public.get_file_inbox_lists_count(
	_receiverid bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
DECLARE total BIGINT;
_query text;
_keyword text;
BEGIN
    total :=0;
    _keyword :='''%'||keyword||'%''';
    _query :='SELECT count(*) 
		FROM PUBLIC.jet_process_filemovement as fm 
        Join (select max(mov.fmid) as mfmId from PUBLIC.jet_process_filemovement mov where mov.active_ = true group by mov.fileId) fmov on fmov.mfmId = fm.fmid  
		  JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
		 JOIN PUBLIC.masterdata_userpost as up1 ON fm.senderid = up1.userpostid
		 JOIN PUBLIC.masterdata_userpost as up2
		ON fm.receiverid = up2.userpostid 
	    where  fm.pullbackremark is null AND fm.receiverid ='|| _receiverid;
        IF _receiverid !=0 AND _receiverid IS NOT NULL THEN 
            
            IF  keyword IS NOT NULL  THEN
                 EXECUTE _query|| ' AND  (f.filenumber ilike '||_keyword||' OR f.subject ilike '||_keyword||')' INTO total ;       
                 return total;
            END IF;
                 EXECUTE _query INTO total;
            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_file_inbox_lists_count(bigint, text)
    OWNER TO postgres;

--------------- Get-put-in-file-list-count----------------------------------

CREATE OR REPLACE FUNCTION public.get_put_in_file_list_count(
	_type text,
	user_post_id bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
DECLARE
total BIGINT;
_query text;
_nature text;
_keyword text;
BEGIN
    total :=0;
    _nature :='';
    _keyword :='''%'||keyword||'%''';
    _query :='SELECT COUNT(*) 
              from public.jet_process_receipt as r 
              inner join public.md_category as c on r.receiptcategoryid = c.categorydataid
              inner join public.jet_process_receiptmovement rmt on r.receiptid = rmt.receiptid 
              where rmt.rmid = (select max(rmid) from public.jet_process_receiptmovement where receiptid = r.receiptid AND pullbackremark IS NULL)
              and (rmt.movementtype = 1 OR rmt.movementtype=0) and r.attachstatus is null and r.currentstate != 3 AND r.currentlywith='||user_post_id;
        IF (_type ='Electronic') THEN
                _nature :=' AND f.nature = ''Electronic'' ';
        END IF;
        
        IF user_post_id !=0 AND user_post_id IS NOT NULL THEN 
            
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
                IF(_type ='Electronic' ) THEN
                 
                    EXECUTE _query||' AND r.nature = ''Electronic''  AND f.nature = ''Electronic''   AND (r.receiptnumber ilike '||_keyword||'  OR r.subject ilike '||_keyword||')' INTO total;
                   return total;
            ELSE
                    EXECUTE _query|| ' AND (r.receiptnumber ilike '||_keyword||' OR r.subject ilike '||_keyword||')' INTO total;
                   return total;
               END IF;   
            END IF;
                
                IF(_type ='Electronic' ) THEN
                    EXECUTE _query||' AND r.nature = ''Electronic''   AND (r.receiptnumber ilike '||_keyword||'  OR r.subject ilike '||_keyword||')' INTO total;
                   return total;
                ELSE
                
                    EXECUTE _query INTO total;
                   return total;
                  END IF;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_put_in_file_list_count(text, bigint, text)
    OWNER TO postgres;


    

-----------------File-Sent-List-Count------------------

CREATE OR REPLACE FUNCTION public.get_file_sent_lists_count(
	sender_id bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
DECLARE total BIGINT;
_query text;
_keyword text;
BEGIN
        total :=0;
        _keyword :='''%'||keyword||'%''';
        _query :='SELECT count(*) 
                    FROM PUBLIC.jet_process_filemovement as fm 
                    JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
                    JOIN PUBLIC.masterdata_userpost as up1 ON fm.receiverid = up1.userpostid 
                    JOIN PUBLIC.masterdata_userpost as up2 ON f.currentlywith = up2.userpostid 
                    where currentstate = 2  AND fm.active_ = true  AND fm.pullbackremark is null  AND fm.senderid ='|| sender_id;
        IF sender_id !=0 AND sender_id IS NOT NULL THEN 
            
            
            IF  keyword IS NOT NULL  THEN
   
					
                  EXECUTE _query|| ' AND  (f.filenumber ilike '||_keyword||' OR f.subject ilike '||_keyword||')' INTO total ;       
            
            return total;
            END IF;
                EXECUTE _query INTO total;
            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_file_sent_lists_count(bigint, text)
    OWNER TO postgres;

    

-----------------------------Get-File-Movement-Count-----------------------

CREATE OR REPLACE FUNCTION public.get_file_movement_list_count(
	filemovement_id bigint,
	file_id bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
DECLARE 
     total BIGINT;
    _query text;
BEGIN
    total :=0;
    _query :='SELECT count(*) 
            FROM PUBLIC.jet_process_filemovement as fm 
            left outer JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
            left outer JOIN PUBLIC.masterdata_userpost as up1 ON fm.receiverid = up1.userpostid
            left outer JOIN PUBLIC.masterdata_userpost as up2 ON fm.senderid = up2.userpostid WHERE  fm.movementtype != 0 AND fm.active_ = true AND fm.fileId ='|| file_id ||'AND fm.fmid <='|| filemovement_id;
  	 IF file_id !=0 AND file_id IS NOT NULL THEN 
            IF  keyword !='' AND keyword IS NOT NULL  THEN
             
                EXECUTE _query ||' AND (filenumber ilike '||_keyword||' OR subject ilike '||_keyword||' OR  categoryvalue ilike '||_keyword||')' INTO total ;       

                RETURN total;
            END IF;
                EXECUTE _query INTO total;
            RETURN total;
            END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_file_movement_list_count(bigint, bigint, text)
    OWNER TO postgres;

    

--------Get-receipt-movement-list-Count---------------------------

CREATE OR REPLACE FUNCTION public.get_receipt_movement_list_count(
	receiptmovement_id bigint,
	receipt_id bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
DECLARE 
total BIGINT;
_query text;
_keyword text;
BEGIN
    total :=0;   
    _keyword := '''%'||keyword||'%''';
    _query :='SELECT COUNT(*)
            FROM PUBLIC.jet_process_receiptmovement as rm 
            left outer JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
            left outer JOIN PUBLIC.masterdata_userpost as up1 ON rm.receiverid = up1.userpostid 
            left outer JOIN PUBLIC.masterdata_userpost as up2 ON rm.senderid = up2.userpostid
            WHERE  rm.movementtype != 0 AND active_ = true AND rm.receiptid ='||receipt_id ||'AND rm.rmid <='|| receiptmovement_id; 
        
        IF receipt_id !=0 AND receipt_id IS NOT NULL THEN 
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
   
             EXECUTE _query|| '  AND (filenumber ilike '||_keyword||' OR subject ilike '||_keyword||' OR  categoryvalue ilike '||keyword||')' INTO total ;       
            
            return total;
            END IF;
             EXECUTE _query INTO total;
            
            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_receipt_movement_list_count(bigint, bigint, text)
    OWNER TO postgres;
    
    
    
        
--    ----------------------------------------  Get Receipt List count ---------------------------------------

  
CREATE OR REPLACE FUNCTION public.get_receipt_created_list_count(
	post_id bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
  
      declare
      _query text;
      _keyword text;
       total bigint ;
        
      begin

        total :=0;
        _keyword :='''%'||keyword||'%''';
        _query :='SELECT count(*)  FROM public.jet_process_receipt INNER JOIN 
            public.md_category  ON categorydataid = receiptcategoryid where  currentstate = 1 AND attachstatus IS NULL AND userpostid ='|| post_id;
        IF post_id !=0 AND post_id IS NOT NULL THEN 
            
            
            IF  keyword IS NOT NULL  THEN
   
             
          
        	EXECUTE _query ||' AND (receiptnumber ilike '||_keyword||' OR subject ilike '||_keyword||' OR categoryvalue ilike '||_keyword||')' INTO total ;       
            
            return total;
            END IF;
                EXECUTE _query INTO total;
            RETURN total;
        END IF;

        RETURN total;
      end;
  
$BODY$;

ALTER FUNCTION public.get_receipt_created_list_count(bigint, text)
    OWNER TO postgres;

    
    
--    ------------------------------------- Get Receipt Inbox List Count -------------------------------------------

    
 CREATE OR REPLACE FUNCTION public.get_receipt_inbox_list_count(
	post_id bigint,
	keyword text
	)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
  
      declare
      _query text;
      _keyword text;
       total bigint ;
        
      begin

        total :=0;
        _keyword :='''%'||keyword||'%''';
        _query :='SELECT count(*) 
                FROM PUBLIC.jet_process_receiptmovement as rm 
                Join (select max(mov.rmid) as mreceiptId from PUBLIC.jet_process_receiptmovement mov where mov.active_ = true AND movementtype !=2 group by mov.receiptId) rmov on rmov.mreceiptId = rm.rmid  
                JOIN PUBLIC.jet_process_receipt AS r ON rm.receiptId = r.receiptId
                JOIN PUBLIC.masterdata_userpost as up1 ON rm.senderid = up1.userpostid
                JOIN PUBLIC.masterdata_userpost as up2 ON rm.receiverid = up2.userpostid 
                where attachstatus is null AND rm.receiverid ='|| post_id;
        IF post_id !=0 AND post_id IS NOT NULL THEN 
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
   
             EXECUTE _query || ' AND r (r.receiptnumber ilike '||_keyword||' OR r.subject ilike '||_keyword||')' INTO total ;       
            
            return total;
            END IF;
               EXECUTE _query INTO total;
            RETURN total;
        END IF;

        RETURN total;
      end;
  
$BODY$;

ALTER FUNCTION public.get_receipt_inbox_list_count(bigint,text)
    OWNER TO postgres;
    
    
    
--    ------------------------------------- Get Receipt Sent List Count -------------------------------------------

   CREATE OR REPLACE FUNCTION public.get_receipt_sent_list_count(
	post_id bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
	AS $BODY$
  
      declare
      _query text;
      _keyword text;
       total bigint ;
        
      begin

        total :=0;
        _keyword :='''%'||keyword||'%''';
        _query :='SELECT count(*) 
                 FROM PUBLIC.jet_process_receiptmovement as rm 
				 JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
				 JOIN PUBLIC.masterdata_userpost as up ON rm.receiverid = up.userpostid
		         where rm.active_ = true and rm.pullbackremark is null and rm.movementtype = 1  AND rm.senderid  ='||post_id;
        IF post_id !=0 AND post_id IS NOT NULL THEN 
            
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
   
                EXECUTE _query||' AND (r.receiptnumber ilike '||_keyword||' OR r.subject ilike '||_keyword||')' INTO total ;       
            return total; 
            END IF;
                EXECUTE _query INTO total;
            RETURN total;
        END IF;

        RETURN total;
      end;
  
$BODY$;

ALTER FUNCTION public.get_receipt_sent_list_count(bigint, text)
    OWNER TO postgres;
    

--    ---------------------------------------  Get file correspondence list count   ---------------------------------------------
 

CREATE OR REPLACE FUNCTION public.get_file_correspondence_list_count(
	_viewmode text,
    filemovement_id bigint,
	file_id bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
DECLARE total BIGINT;
_query text;
viewmode text;
_keyword text;
BEGIN
     total :=0;
    _keyword :='''%'||keyword||'%''';
    _query :='SELECT count(*)  FROM PUBLIC.jet_process_receipt r INNER JOIN 
              PUBLIC.jet_process_filecorrreceipt as fc  ON r.receiptid = fc.receiptid
              where fc.detachremark IS NULL AND fc.docfileid ='|| file_id;
  	 IF file_id !=0 AND file_id IS NOT NULL THEN 
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
            
                IF( _viewmode ='ViewModeFromSentFile') THEN
   
                 EXECUTE _query ||' AND fc.filemovementId <'||filemovement_id INTO total ; 
                 return total;
                END IF;
               
              IF(_viewmode ='' OR _viewmode IS NULL) THEN
                  EXECUTE _query||' AND fc.filemovementId <='filemovement_id INTO total; 
                  return total;
              END IF;
            END IF;
                  IF( _viewmode ='ViewModeFromSentFile') THEN
                 EXECUTE _query ||' AND fc.filemovementId <'||filemovement_id INTO total; 
                return total;
                END IF;
               
              IF(_viewmode ='' OR _viewmode IS NULL) THEN
                   EXECUTE _query ||' AND fc.filemovementId <='||filemovement_id ; 

                return total;
              END IF;
                
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_file_correspondence_list_count(text,bigint, bigint, text)
    OWNER TO postgres;
   
--    ---------------------------- Attach Receipt Movement list count -----------------------------
 

CREATE OR REPLACE FUNCTION public.get_attach_receipt_movement_list_count(
	receipt_id bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
DECLARE total BIGINT;
_query text;
_keyword text;
BEGIN
        total :=0;      
        _keyword :='''%'||keyword||'%''';
        _query :='SELECT count(*) 
            FROM PUBLIC.jet_process_receiptmovement as rm 
            left outer JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
            left outer JOIN PUBLIC.masterdata_userpost as up1 ON rm.receiverid = up1.userpostid 
            left outer JOIN PUBLIC.masterdata_userpost as up2 ON rm.senderid = up2.userpostid 
            WHERE  rm.movementtype != 0 AND active_ = true AND rm.receiptid ='||receipt_id ;
        
        IF receipt_id !=0 AND receipt_id IS NOT NULL THEN 
            IF  keyword !='' AND keyword IS NOT NULL  THEN
            
            
            EXECUTE _query||' AND (filenumber ilike '||_keyword||' OR subject ilike '||_keyword||' OR  categoryvalue ilike '||_keyword||')' INTO total ;       
            
            return total;
            END IF;
             EXECUTE _query INTO total;
            
            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_attach_receipt_movement_list_count(bigint, text)
    OWNER TO postgres;
    
--------------------------attach receipt in existing file count-----------------------------

    
CREATE OR REPLACE FUNCTION public.get_receipt_attach_in_file_list_count(
    _type text,
	user_post_id bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
DECLARE total BIGINT;
_query text;
_nature text;
_keyword text; 
BEGIN
        total :=0;
        _nature :='';
        _keyword := '''%'||keyword||'%''';
        _query :='SELECT COUNT(*) 
                    from public.jet_process_docfile as f 
                    inner join public.md_category as c on f.categoryid = c.categorydataid
                    inner join public.jet_process_filemovement fmt on f.docfileid = fmt.fileid 
                    where fmt.fmid = (select max(fmid) from public.jet_process_filemovement where fileid = f.docfileid AND pullbackremark is null)
                    and (fmt.movementtype = 1 OR fmt.movementtype=0) AND f.currentlywith='|| user_post_id ;
        _keyword :='';
        IF (_type ='Physical') THEN
                _nature :=' AND f.nature = ''Physical'' ';
        END IF;
        
        IF user_post_id !=0 AND user_post_id IS NOT NULL THEN 
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
                   IF(_type ='Physical' ) THEN
                 
                     EXECUTE _query ||' AND f.nature = ''Physical''  AND (f.filenumber ilike '||keyword||'  OR f.subject ilike '||keyword||')' INTO total;
                return total; 
                ELSE
                    EXECUTE _query||' AND (f.filenumber ilike '||_keyword||'  OR f.subject ilike '||_keyword||')' INTO total;
                    return total;
                END IF;
                
            END IF;
               IF(_type ='Physical' ) THEN
                 
                   EXECUTE _query ||' AND f.nature ='||'Physical' INTO total ;
                return total; 
                ELSE
                    EXECUTE _query INTO total;
                    return total;
                END IF;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_receipt_attach_in_file_list_count(text,bigint, text)
    OWNER TO postgres;
    
 
   

   
------------------------closed receipt list--------------------------
   
    
CREATE OR REPLACE FUNCTION public.get_closed_receipt_list_count(
	_closedby bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
declare 
    total bigint;
    _query text;
    _keyword text;
begin
    total := 0;
    _keyword :='''%'||keyword||'%''';
    _query :='SELECT COUNT(*) 
            FROM PUBLIC.jet_process_receiptclosedetail as cr 
            JOIN PUBLIC.jet_process_receipt AS r ON cr.receiptId = r.receiptId where cr.closedby ='|| _closedby;
    IF _closedby != 0 AND _closedby IS NOT NULL THEN
    
        IF  keyword !='' AND keyword IS NOT NULL  THEN
    
            
           EXECUTE _query||' AND (r.receiptnumber ilike '||_keyword||'  OR r.subject ilike '||_keyword||')' INTO total;
            RETURN total;
       
       END IF;
            
            EXECUTE _query INTO total;
            RETURN total;
       
       END IF;
  RETURN total;

END;

$BODY$;

ALTER FUNCTION public.get_closed_receipt_list_count(bigint, text)
    OWNER TO postgres;
    
    
    
    
    
    -- FUNCTION: public.get_closed_file_list(bigint, text, integer, integer, text, text)

-- DROP FUNCTION IF EXISTS public.get_closed_file_list(bigint, text, integer, integer, text, text);

CREATE OR REPLACE FUNCTION public.get_closed_file_list(
	_closedby bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	orderbytype text)
    RETURNS TABLE(closefileid bigint, fileid bigint, closedby bigint, closingremarks character varying, reopendate timestamp without time zone, reopenremarks character varying, closingmovementid bigint, reopenby bigint, createdate timestamp without time zone, nature character varying, filenumber character varying, subject character varying, dealingheadsectionid bigint) 
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    ROWS 1000

    SET search_path=admin, pg_temp
AS $BODY$
declare 
    _closedby bigint;
    _keyword text;
    _offset int;
    _limit int;
    _orderby text;
    _order text;
    _query text;
begin
    _closedby := closedby;
    _query := 'SELECT f.fileclosedid as closedFileId , f.fileid as fileId , f.closedby as closedBy, f.closingremarks as closingRemarks , 
                f.reopendate as reopenDate , f.reopenremarks as reopenRemaks , f.closedmovementid as closingMovementId ,
                f.reopenby as reopenBy, f.createdate as closedOn , d.nature as nature , d.filenumber as fileNumber , d.subject as subject , d.dealingheadsectionid  as dealingHeadSectionId 
                FROM PUBLIC.jet_process_fileclosedetail as f 
                JOIN PUBLIC.jet_process_docfile AS d ON d.docfileId = f.fileid ';
                
     _keyword := '''%' || keyword || '%''';
     IF (_start <0 OR _start IS NULL) THEN
        _offset := 0;
     ELSE 
        _offset := _start;
     END IF;
     
     IF(_end <= 0 OR _end IS NULL) THEN
        _limit := 4;
     ELSE
        _limit := _end;
     END IF;
     
     IF (orderbycol = '' OR orderbycol = 'closedOn' OR orderbycol = 'closedon' OR orderbycol = 'createDate' OR orderbycol = 'createdate') THEN
        _orderBy := ' f.createdate ';
     END IF;
     
      IF (orderbycol = 'filenumber' OR orderbycol = 'createDate' OR orderbycol = 'fileNumber') THEN
        _orderBy := ' d.filenumber ';
     END IF;
     
       IF (orderbycol = 'subject') THEN
        _orderBy := ' d.subject ';
     END IF;
     
     IF(orderByType ='' or orderByType IS NULL) THEN
        _order := ' desc ';
     ELSE 
        _order := orderbytype;
     END IF;
    
    IF(_closedby !=0) THEN
        _query := _query ||' where closedby = ' || _closedby;
        
        IF (_keyword IS NOT NULL) THEN 
            _query := _query || 'AND (filenumber ilike ' || _keyword || 'OR subject ilike ' || _keyword || ')';
            
            if(_orderBy != '') THEN
                _query := _query || ' order by ' || _orderBy;
                
                if(_order != '') THEN
                    _query := _query || '' || _order;
                
                    if(_offset >= 0 ) THEN
                        _query := _query || ' offset ' || _offset;
                        
                        if(_limit > 0 ) THEN 
                            _query := _query || ' limit ' || _limit;
                            
                        END IF;
                    
                    END IF;
                    
                END IF;
            
            END IF;
            
        END IF;
   
   END IF;
  
  return query execute _query;

end;

$BODY$;

ALTER FUNCTION public.get_closed_file_list(bigint, text, integer, integer, text, text)
    OWNER TO postgres;






-- FUNCTION: public.get_closed_file_list_count(bigint, text)

-- DROP FUNCTION IF EXISTS public.get_closed_file_list_count(bigint, text);

CREATE OR REPLACE FUNCTION public.get_closed_file_list_count(
	_closedby bigint,
	keyword text)
    RETURNS bigint
    LANGUAGE 'plpgsql'
    COST 100
    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
    SET search_path=admin, pg_temp
AS $BODY$
declare 
    total bigint;
    _query text;
    _keyword text;
begin
    total := 0;
    _keyword :='''%'||keyword||'%''';
    _query :='SELECT COUNT(*) 
            FROM PUBLIC.jet_process_fileclosedetail as cr 
            JOIN PUBLIC.jet_process_docfile AS r ON cr.fileId = r.docfileId where cr.closedby ='|| _closedby;
    IF _closedby != 0 AND _closedby IS NOT NULL THEN
    
        IF  keyword !='' AND keyword IS NOT NULL  THEN
    
            
           EXECUTE _query||' AND (r.filenumber ilike '||_keyword||'  OR r.subject ilike '||_keyword||')' INTO total;
            RETURN total;
       
       END IF;
            
            EXECUTE _query INTO total;
            RETURN total;
       
       END IF;
  RETURN total;

END;

$BODY$;

ALTER FUNCTION public.get_closed_file_list_count(bigint, text)
    OWNER TO postgres;
    

 