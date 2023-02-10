
-- -------------------  Dropping All Function ----------------------------

DROP FUNCTION IF EXISTS public.get_file_created_list_count(bigint, text);

DROP FUNCTION IF EXISTS public.get_file_inbox_lists_count(bigint, text);

DROP FUNCTION IF EXISTS public.get_put_in_file_list_count(bigint, text);

DROP FUNCTION IF EXISTS public.get_file_sent_lists_count(bigint, text);

DROP FUNCTION IF EXISTS public.get_file_created_list(bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_put_in_file_list(bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_file_inbox_list(bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_file_sent_list(bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_file_movement_list(bigint,bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_file_movement_list_count(bigint , bigint,  text);

DROP FUNCTION IF EXISTS public.get_receipt_movement_list(bigint,bigint, text, integer, integer, text, text);

DROP FUNCTION IF EXISTS public.get_receipt_movement_list_count(bigint , bigint, text);


-- ---------------------File created list count  --------------------------

CREATE OR REPLACE FUNCTION public.get_file_created_list(
	post_id bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(fmid bigint,docfileid bigint, filenumber character varying, subject character varying, category character varying, remark character varying, createdon timestamp without time zone, nature character varying) 
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
                        f.remarks as remark,f.createdate as createdon ,  f.nature as nature
                        FROM public.jet_process_docfile f  INNER JOIN public.md_category c 
                        ON c.categorydataid = f.categoryid
                        INNER JOIN public.jet_process_filemovement as fm ON fm.fileid = f.docfileid where fm.movementtype=0 AND currentstate = 1   ';
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
    
    
    
    
--  ----------------  File Sent List  count ---------------

 

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

        
      
        
        IF sender_id !=0 AND sender_id IS NOT NULL THEN 
            
            
            IF  keyword IS NOT NULL  THEN
   
					SELECT count(*) into total
                    FROM PUBLIC.jet_process_filemovement as fm 
                    JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
                    JOIN PUBLIC.masterdata_userpost as up1 ON fm.receiverid = up1.userpostid 
                    JOIN PUBLIC.masterdata_userpost as up2 ON f.currentlywith = up2.userpostid 
                    where currentstate = 2  AND fm.active_ = true  AND fm.senderid = sender_id
                    AND fm.pullbackremark is null AND  (f.filenumber ilike '%'||keyword||'%' OR f.subject ilike '%'||keyword||'%') ;       
            
            return total;
            END IF;
                SELECT count(*) into total
                FROM PUBLIC.jet_process_filemovement as fm 
                JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
                JOIN PUBLIC.masterdata_userpost as up1 ON fm.receiverid = up1.userpostid 
                JOIN PUBLIC.masterdata_userpost as up2 ON f.currentlywith = up2.userpostid 
                where currentstate = 2  AND fm.active_ = true  AND fm.senderid = sender_id;
			

            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_file_sent_lists_count(bigint, text)
    OWNER TO postgres;



-- ------------------------  Get File List  -----------------------------

    
    -- FUNCTION: public.get_file_created_list_count(bigint, text)

-- DROP FUNCTION IF EXISTS public.get_file_created_list_count(bigint, text);

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
BEGIN
total :=0;

        
      
        
        IF post_id !=0 AND post_id IS NOT NULL THEN 
            
            
            IF  keyword IS NOT NULL  THEN
   
            Select  count(*) into total FROM public.jet_process_docfile  
            INNER JOIN public.md_category  
            ON categorydataid = categoryid 
            where userpostid = post_id  AND  currentstate = 1 
            AND (filenumber ilike '%'||keyword||'%' OR subject ilike '%'||keyword||'%' OR  categoryvalue ilike '%'||keyword||'%') ;       
            
            return total;
            END IF;
             Select  count(*) into total FROM public.jet_process_docfile  
            INNER JOIN public.md_category  
            ON categorydataid = categoryid 
            where userpostid = post_id  AND  currentstate = 1 ;
            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_file_created_list_count(bigint, text)
    OWNER TO postgres;

    
    
--  -----------------------  Get File Inbox List  ----------------------------------


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

        
      
        
        IF _receiverid !=0 AND _receiverid IS NOT NULL THEN 
            
            
            IF  keyword IS NOT NULL  THEN
   
           
        SELECT count(*) into total
		FROM PUBLIC.jet_process_filemovement as fm 
        Join (select max(mov.fmid) as mfmId from PUBLIC.jet_process_filemovement mov where mov.active_ = true group by mov.fileId) fmov on fmov.mfmId = fm.fmid  
		JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
		JOIN PUBLIC.masterdata_userpost as up1 ON fm.senderid = up1.userpostid
		JOIN PUBLIC.masterdata_userpost as up2
		ON fm.receiverid = up2.userpostid  
	    where fm.receiverid = _receiverid AND fm.pullbackremark is null AND  (f.filenumber ilike '%'||keyword||'%' OR f.subject ilike '%'||keyword||'%') ;       
            
            return total;
            END IF;
                
        SELECT count(*) into total
		FROM PUBLIC.jet_process_filemovement as fm 
        Join (select max(mov.fmid) as mfmId from PUBLIC.jet_process_filemovement mov where mov.active_ = true group by mov.fileId) fmov on fmov.mfmId = fm.fmid  
		  JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
		 JOIN PUBLIC.masterdata_userpost as up1 ON fm.senderid = up1.userpostid
		 JOIN PUBLIC.masterdata_userpost as up2
		ON fm.receiverid = up2.userpostid 
	    where fm.receiverid = _receiverid;

			

	    
            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_file_inbox_lists_count(bigint, text)
    OWNER TO postgres;

    
    
    
    

CREATE OR REPLACE FUNCTION public.get_file_inbox_list(
	receiverid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(filemovementid bigint, filenumber character varying, subject character varying, sentby text, sentto text, senton timestamp without time zone, readon character varying, duedate timestamp without time zone, remark character varying, receivedon character varying, currentlywith bigint, nature character varying, fileid bigint, senderid bigint, currentstate integer, docfileid bigint, pullbackremark character varying, currentlywithusername text) 
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
      
      
   _query=' SELECT fm.fmid as fileMovementId, f.filenumber as fileNumber ,f.subject as subject,
		(SELECT concat(up1.username,''('',  up1.postmarking,'')'',  up1.sectionname,'','', up1.departmentname)) as sentBy,
		(SELECT concat(up2.username, ''('',up2.postmarking,'')'', up2.sectionname,'','', up2.departmentname)) AS SentTo ,
		fm.createdate as sentOn, fm.readon as readOn, fm.duedate as dueDate, fm.remark as remark, fm.receivedon as receivedOn,
		f.currentlywith as currentlyWith, f.nature as nature, f.docfileid as fileId, fm.senderid as senderId , 
        f.currentstate as currentState , f.docfileid as docFileId , fm.pullbackremark as pullBackRemark , null as currentlywithusername
		FROM PUBLIC.jet_process_filemovement as fm 
        Join (select max(mov.fmid) as mfmId from PUBLIC.jet_process_filemovement mov where mov.active_ = true group by mov.fileId) fmov on fmov.mfmId = fm.fmid  
		JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
		JOIN PUBLIC.masterdata_userpost as up1 ON fm.senderid = up1.userpostid
		JOIN PUBLIC.masterdata_userpost as up2
		ON fm.receiverid = up2.userpostid ';
                  
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
    
--    ----------------------------- Get File Sent List  ------------------------------------------

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
    

    

-- --------------------------------------------- Receipt Count  --------------------------------------

    
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

        IF post_id !=0 AND post_id IS NOT NULL THEN 
            
            
            IF  keyword IS NOT NULL  THEN
   
            SELECT count(*) into total FROM public.jet_process_receipt INNER JOIN 
        public.md_category  ON categorydataid = receiptcategoryid where userpostid = post_id 
        AND currentstate = 1 AND attachstatus IS NULL AND  
        (receiptnumber ilike '%'||keyword||'%' OR subject ilike '%'||keyword||'%' OR categoryvalue ilike '%'||keyword||'%') ;       
            
            return total;
            END IF;
                SELECT count(*) into total FROM public.jet_process_receipt INNER JOIN 
        public.md_category  ON categorydataid = receiptcategoryid where userpostid = post_id 
        AND currentstate = 1 AND attachstatus IS NULL;
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

        IF post_id !=0 AND post_id IS NOT NULL THEN 
            
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
   
            SELECT count(*) into total
	FROM PUBLIC.jet_process_receiptmovement as rm 
    
    Join (select max(mov.rmid) as mreceiptId from PUBLIC.jet_process_receiptmovement mov where mov.active_ = true group by mov.receiptId) rmov on rmov.mreceiptId = rm.rmid  
    
	JOIN PUBLIC.jet_process_receipt AS r ON rm.receiptId = r.receiptId
	JOIN PUBLIC.masterdata_userpost as up1 ON rm.senderid = up1.userpostid
	JOIN PUBLIC.masterdata_userpost as up2 ON rm.receiverid = up2.userpostid 
    where rm.receiverid = post_id and r.attachstatus is null AND (r.receiptnumber ilike '%'||keyword||'%' OR r.subject ilike '%'||keyword||'%') ;       
            
            return total;
            END IF;
                SELECT count(*) into total
	FROM PUBLIC.jet_process_receiptmovement as rm 
    
    Join (select max(mov.rmid) as mreceiptId from PUBLIC.jet_process_receiptmovement mov where mov.active_ = true group by mov.receiptId) rmov on rmov.mreceiptId = rm.rmid  
    
	JOIN PUBLIC.jet_process_receipt AS r ON rm.receiptId = r.receiptId
	JOIN PUBLIC.masterdata_userpost as up1 ON rm.senderid = up1.userpostid
	JOIN PUBLIC.masterdata_userpost as up2 ON rm.receiverid = up2.userpostid 
    where rm.receiverid = post_id and r.attachstatus is null;
            RETURN total;
        END IF;

        RETURN total;
      end;
  
$BODY$;

ALTER FUNCTION public.get_receipt_inbox_list_count(bigint,text)
    OWNER TO postgres;
    
    
    

--    ------------------------------------- Get Receipt Sent List Count -------------------------------------------


-- DROP FUNCTION IF EXISTS public.get_receipt_sent_list_count(bigint, text);

 
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

        IF post_id !=0 AND post_id IS NOT NULL THEN 
            
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
   
                 SELECT count(*) into total
                 FROM PUBLIC.jet_process_receiptmovement as rm 
		JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
		JOIN PUBLIC.masterdata_userpost as up ON rm.receiverid = up.userpostid
        where rm.active_ = true and rm.pullbackremark is null and rm.movementtype = 1  AND rm.senderid  =post_id AND (r.receiptnumber ilike '%'||keyword||'%' OR r.subject ilike '%'||keyword||'%') ;       
                                    
            return total; 
            END IF;
                SELECT count(*) into total
		        FROM PUBLIC.jet_process_receiptmovement as rm 
		JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
		JOIN PUBLIC.masterdata_userpost as up ON rm.receiverid = up.userpostid
        where rm.active_ = true and rm.pullbackremark is null and rm.movementtype = 1  AND rm.senderid  =post_id;
            RETURN total;
        END IF;

        RETURN total;
      end;
  
$BODY$;

ALTER FUNCTION public.get_receipt_sent_list_count(bigint, text)
    OWNER TO postgres;
    
    
 -- --------------------------------------------- Receipt List  --------------------------------------
  
    
 --    ----------------------------------------  Get Receipt List  ---------------------------------------
 
CREATE OR REPLACE FUNCTION public.get_receipt_created_list(
	post_id bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(receiptid bigint, receiptnumber character varying, subject character varying, category character varying, createdate timestamp without time zone, remark character varying, viewpdfurl character varying, nature character varying) 
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
    _query:='SELECT receiptid as receiptId , receiptnumber as receiptnumber , 
    subject as subject , categoryvalue as category , createDate as createDate ,  
    remarks as remark , viewpdfurl AS viewpdfurl ,
	nature AS nature FROM PUBLIC.jet_process_receipt INNER JOIN 
	PUBLIC.md_category  ON categorydataid = receiptcategoryid where currentstate = 1 AND attachstatus IS NULL ';
    
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
                _orderBy :='modifieddate';
        END IF;
        IF ( orderbycol ='createdon' OR orderbycol ='createdOn' OR orderbycol='createDate' OR orderbycol='createdate') THEN
                _orderBy :='createdate';
        END IF;
         IF (orderbycol ='receiptnumber' OR orderbycol ='receiptNumber') THEN
                _orderBy :='receiptnumber';
        END IF;
         IF (orderbycol ='subject') THEN
                _orderBy :='subject';
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

 CREATE OR REPLACE FUNCTION public.get_receipt_inbox_list(
	receiverid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(receiptmovementid bigint, receiptnumber character varying, subject character varying, sender text, sentby text, sentto text, senton timestamp without time zone, readon character varying, duedate timestamp without time zone, remark character varying, receiveon character varying, nature character varying, receiptid bigint, pullbackremark character varying) 
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

                Join (select max(mov.rmid) as mreceiptId from PUBLIC.jet_process_receiptmovement mov where mov.active_ = true group by mov.receiptId) rmov on rmov.mreceiptId = rm.rmid  

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

  
    -- FUNCTION: public.get_receipt_sent_list(bigint, text, integer, integer, text, text)

-- DROP FUNCTION IF EXISTS public.get_receipt_sent_list(bigint, text, integer, integer, text, text);

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

    
    
    
    
--     ------------------------------ Get put in file list count  -----------------------------------------------------------------

    

    CREATE OR REPLACE FUNCTION public.get_put_in_file_list_count(
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
BEGIN
total :=0;

        
        IF user_post_id !=0 AND user_post_id IS NOT NULL THEN 
            
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
   
                 
                    SELECT COUNT(*) INTO total
                    FROM PUBLIC.jet_process_receipt r 
                    JOIN ( select max(mov.rmid) as mreceiptId, receiptId FROM PUBLIC.jet_process_receiptmovement mov 
                                                                    where mov.active_ = true OR mov.movementtype=0
                    group by mov.receiptId) as fmov on fmov.receiptId = r.receiptid
                    INNER JOIN  PUBLIC.jet_process_receiptmovement rmt on rmt.rmid=fmov.mreceiptId 

                    JOIN PUBLIC.md_category c ON c.categorydataid = r.receiptcategoryid  
    
                    where  r.attachstatus is null  AND r.currentlywith= user_post_id  AND (r.receiptnumber ilike '%'||keyword||'%'  OR r.subject ilike '%'||keyword||'%');
            return total;
            END IF;
                
                SELECT COUNT(*) INTO total
                    FROM PUBLIC.jet_process_receipt r 
                    JOIN ( select max(mov.rmid) as mreceiptId, receiptId FROM PUBLIC.jet_process_receiptmovement mov 
                                                                    where mov.active_ = true OR mov.movementtype=0
                    group by mov.receiptId) as fmov on fmov.receiptId = r.receiptid
                    INNER JOIN  PUBLIC.jet_process_receiptmovement rmt on rmt.rmid=fmov.mreceiptId 

                    JOIN PUBLIC.md_category c ON c.categorydataid = r.receiptcategoryid  
    
                    where  r.attachstatus is null  AND r.currentlywith= user_post_id ;
            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_put_in_file_list_count(bigint, text)
    OWNER TO postgres;
--    -------------------------------------------------- Get Put in file List  ----------------------------------------------------

 

CREATE OR REPLACE FUNCTION public.get_put_in_file_list(
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
        where rmt.rmid = (select max(rmid) from public.jet_process_receiptmovement where receiptid = r.receiptid)
            and (rmt.movementtype = 1 OR rmt.movementtype=0) and r.attachstatus is null ';
  
 
                
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
     
                      
                      IF (userpostid !=0 )THEN
                                             
                           _query := q1|| ' AND r.currentlywith='||userpostid;
                          
                             if (keyword IS NOT NULL  ) THEN  
                                   _query := '';
                                   _query := q1|| ' AND r.currentlywith= '||userpostid||'  AND (r.receiptnumber ilike '||_keyword ||' OR r.subject ilike '||_keyword ||')';
                        
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

ALTER FUNCTION public.get_put_in_file_list(bigint, text, integer, integer, text, text)
    OWNER TO postgres;
    
--    -------------------------------------  Get File Movement Count  -----------------------------------------------

    
    
    -- FUNCTION: public.get_file_movement_list_count(bigint, text)

-- DROP FUNCTION IF EXISTS public.get_file_movement_list_count(bigint, text);

-- FUNCTION: public.get_file_movement_list_count(bigint, text)

-- DROP FUNCTION IF EXISTS public.get_file_movement_list_count(bigint,bigint, text);


   -- DROP FUNCTION IF EXISTS public.get_file_movement_list_count(bigint, bigint, text);

-- FUNCTION: public.get_file_movement_list_count(bigint, bigint, text)

-- DROP FUNCTION IF EXISTS public.get_file_movement_list_count(bigint, bigint, text);

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
DECLARE total BIGINT;
_query text;
BEGIN
total :=0;
  	 IF file_id !=0 AND file_id IS NOT NULL THEN 
            
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
   
           SELECT count(*) into total
	FROM PUBLIC.jet_process_filemovement as fm 
	left outer JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
	left outer JOIN PUBLIC.masterdata_userpost as up1 ON fm.receiverid = up1.userpostid
	left outer JOIN PUBLIC.masterdata_userpost as up2 ON fm.senderid = up2.userpostid WHERE fm.fileId = file_id AND fm.fmid <= filemovement_id AND fm.movementtype != 0 AND fm.active_ = true
            AND (filenumber ilike '%'||keyword||'%' OR subject ilike '%'||keyword||'%' OR  categoryvalue ilike '%'||keyword||'%') ;       
            
            return total;
            END IF;
     SELECT count(*) into total
	FROM PUBLIC.jet_process_filemovement as fm 
	left outer JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
	left outer JOIN PUBLIC.masterdata_userpost as up1 ON fm.receiverid = up1.userpostid
	left outer JOIN PUBLIC.masterdata_userpost as up2 ON fm.senderid = up2.userpostid WHERE fm.fileId = file_id AND fm.fmid <= filemovement_id AND fm.movementtype != 0 AND fm.active_ = true ;
       RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_file_movement_list_count(bigint, bigint, text)
    OWNER TO postgres;

   

    
    
    --    -------------------------------------  Get File Movement List  -----------------------------------------------
   -- DROP FUNCTION IF EXISTS public.get_file_movement_list(bigint, text, integer, integer, text, text);

 
-- FUNCTION: public.get_file_movement_list_new(bigint, bigint, text, integer, integer, text, text)

-- DROP FUNCTION IF EXISTS public.get_file_movement_list(bigint, bigint, text, integer, integer, text, text);

-- FUNCTION: public.get_file_movement_list(bigint, bigint, text, integer, integer, text, text)

-- DROP FUNCTION IF EXISTS public.get_file_movement_list(bigint, bigint, text, integer, integer, text, text);

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
 
    --    -------------------------------------  Get Receipt Movement Count  ----------------------------------------------- 
    
    
    
    
    -- FUNCTION: public.get_receipt_movement_list_count(bigint, text)

-- DROP FUNCTION IF EXISTS public.get_receipt_movement_list_count(bigint,bigint, text);

-- FUNCTION: public.get_receipt_movement_list_count(bigint, bigint, text)

-- DROP FUNCTION IF EXISTS public.get_receipt_movement_list_count(bigint, bigint, text);

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
DECLARE total BIGINT;
_query text;
BEGIN
total :=0;      
      
        
        IF receipt_id !=0 AND receipt_id IS NOT NULL THEN 
            
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
   
            
 SELECT 
	count(*) into total
	FROM PUBLIC.jet_process_receiptmovement as rm 
	left outer JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
    left outer JOIN PUBLIC.masterdata_userpost as up1 ON rm.receiverid = up1.userpostid 
	left outer JOIN PUBLIC.masterdata_userpost as up2 ON rm.senderid = up2.userpostid WHERE  rm.receiptid =receipt_id AND rm.rmid <= receiptmovement_id AND rm.movementtype != 0 AND active_ = true
     AND (filenumber ilike '%'||keyword||'%' OR subject ilike '%'||keyword||'%' OR  categoryvalue ilike '%'||keyword||'%') ;       
            
            return total;
            END IF;
             
            SELECT 
            count(*) into total
            FROM PUBLIC.jet_process_receiptmovement as rm 
            left outer JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
            left outer JOIN PUBLIC.masterdata_userpost as up1 ON rm.receiverid = up1.userpostid 
            left outer JOIN PUBLIC.masterdata_userpost as up2 ON rm.senderid = up2.userpostid
            WHERE  rm.receiptid =receipt_id AND rm.rmid <= receiptmovement_id AND rm.movementtype != 0 AND active_ = true;
            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_receipt_movement_list_count(bigint, bigint, text)
    OWNER TO postgres;
    
    
    
    
    --    -------------------------------------  Get Receipt Movement List  -----------------------------------------------
-- DROP FUNCTION IF EXISTS public.get_receipt_movement_list(bigint, bigint, text, integer, integer, text, text);

    
    
    
    -- FUNCTION: public.get_receipt_movement_list(bigint, bigint, text, integer, integer, text, text)

-- DROP FUNCTION IF EXISTS public.get_receipt_movement_list(bigint, bigint, text, integer, integer, text, text);

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


--    ---------------------------------------  Get file correspondence list count   ---------------------------------------------
    
    
  -- FUNCTION: public.get_file_correspondence_list_count(bigint, text)

-- DROP FUNCTION IF EXISTS public.get_file_correspondence_list_count(bigint, text);


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
BEGIN
total :=0;

  	 IF file_id !=0 AND file_id IS NOT NULL THEN 
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
            
                IF( _viewmode ='ViewModeFromSentFile') THEN
   
                SELECT count(*) INTO total FROM PUBLIC.jet_process_receipt r INNER JOIN 
                PUBLIC.jet_process_filecorrreceipt as fc  ON r.receiptid = fc.receiptid where fc.docfileid = file_id  AND fc.filemovementId <filemovement_id ; 
                return total;
                END IF;
               
              IF(_viewmode ='' OR _viewmode IS NULL) THEN
                  SELECT count(*) INTO total FROM PUBLIC.jet_process_receipt r INNER JOIN 
                  PUBLIC.jet_process_filecorrreceipt as fc  ON r.receiptid = fc.receiptid where fc.docfileid = file_id  AND fc.filemovementId <=filemovement_id ; 

                return total;
              END IF;
            END IF;
                     IF( _viewmode ='ViewModeFromSentFile') THEN
   
                SELECT count(*) INTO total FROM PUBLIC.jet_process_receipt r INNER JOIN 
                PUBLIC.jet_process_filecorrreceipt as fc  ON r.receiptid = fc.receiptid where fc.docfileid = file_id  AND fc.filemovementId <filemovement_id ; 
                return total;
                END IF;
               
              IF(_viewmode ='' OR _viewmode IS NULL) THEN
                  SELECT count(*) INTO total FROM PUBLIC.jet_process_receipt r INNER JOIN 
                  PUBLIC.jet_process_filecorrreceipt as fc  ON r.receiptid = fc.receiptid where fc.docfileid = file_id  AND fc.filemovementId <=filemovement_id ; 

                return total;
              END IF;
                
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_file_correspondence_list_count(text,bigint, bigint, text)
    OWNER TO postgres;
  
    
    --    ---------------------------------------  Get file correspondence list    ---------------------------------------------
    
    
    
    
    
    
    
    
    
    
--    ----------------------------------------------------- new query for put in file back up  -------------------------------------------------

    
    
    -- FUNCTION: public.get_put_in_file_list(bigint, integer, integer, integer, text, text)

-- DROP FUNCTION IF EXISTS public.get_put_in_file_list(bigint, integer, integer, integer, text, text);

--CREATE OR REPLACE FUNCTION public.get_put_in_file_list(
--	userpostid bigint,
--	keyword integer,
--	_start integer,
--	_end integer,
--	orderbycol text,
--	_orderbytype text)
--    RETURNS TABLE(receiptid bigint, receiptnumber character varying, subject character varying, category character varying, createdate timestamp without time zone, remark character varying, viewpdfurl character varying, nature character varying,isread boolean ) 
--    LANGUAGE 'plpgsql'
--    COST 100
--    VOLATILE SECURITY DEFINER PARALLEL UNSAFE
--    ROWS 1000
--
--    SET search_path=admin, pg_temp
--AS $BODY$
--   
--   declare 
--       
--       _keyword text;
--       _offset int;
--       _limit int;
--       _orderBy text;
--       _order text;
--       _query text;
--       q1 text;
--       q2 text;
--       q3 text;
--   begin
--     
--     
--  q1='  SELECT r.receiptid, r.receiptnumber , r.subject, ca.categoryvalue as category, r.createDate, r.remarks as remark, null as viewpdfurl , r.nature, true as isread 
--   FROM PUBLIC.jet_process_receipt r INNER JOIN PUBLIC.md_category ca ON ca.categorydataid = r.receiptcategoryid where r.attachstatus is null  ';
--
--   q2=' union 
--   SELECT r.receiptid, r.receiptnumber , r.subject, c.categoryvalue as category, r.createDate, r.remarks as remark, viewpdfurl as null, r.nature,( CASE 
--                                                                                                                                                   WHEN rmt.receivedon  IS NULL OR rmt.receivedon ='''' THEN false 
--                                                                                                                                                   WHEN rmt.receivedon = ''receive'' THEN true
--                                                                                                                                                   ELSE false
--                                                                                                                                                   END
--                                                                                                                                                   )  AS isread 
--   FROM PUBLIC.jet_process_receipt r INNER JOIN  PUBLIC.jet_process_receiptmovement rmt on r.receiptid=rmt.receiptid  INNER JOIN PUBLIC.md_category c ON c.categorydataid = r.receiptcategoryid join(select rm.receiptid as rmreceiptid 
--   from PUBLIC.jet_process_receiptmovement rm Join (select max(mov.rmid) as mreceiptId from PUBLIC.jet_process_receiptmovement mov where mov.active_ = true
--   group by mov.receiptId) rmov on rmov.mreceiptId = rm.rmid ';
--   
--   q3:=') as t on t.rmreceiptid =r.receiptid
--   where  r.attachstatus is null  ';
--   _query :=q1||q2;
--                 
----         _keyword := '''%'||keyword||'%''';
--       _order :=_orderByType;
--       IF (_start <0 OR _start IS NULL) THEN
--           _offset:=0;
--       ELSE
--           _offset :=_start; 
--       END IF;
--       
--       IF (_end <=0 OR _end IS NULL) THEN
--               _limit :=4;
--           ELSE
--               _limit :=_end;
--       END IF;   
--       
--       IF (orderByCol ='' OR orderByCol IS NULL) THEN
--               _orderBy :='createdate';
--           ELSE
--               _orderBy :=orderByCol;
--       END IF;
--       IF (_orderbytype ='' OR _orderbytype IS NULL) THEN
--               _order :='desc';
--           ELSE
--                _order :=_orderbytype;
--       END IF;
--      
--                       
--                       IF (userpostid !=0 )THEN
--                                              
--                            _query := q1|| ' AND r.currentlywith='|| userpostid ||'AND r.userpostid='||userpostid||q2||' where rm.receiverid = '||userpostid||q3;
--                           
--                              if (keyword !=0 AND keyword IS NOT NULL  ) THEN  
--                                       _query := '';
--                                    _query := q1|| ' AND r.userpostid='||userpostid||' AND EXTRACT(YEAR FROM r.createDate) = '||keyword ||q2||' where rm.receiverid= '||userpostid||q3 ||'AND r.currentlywith= '|| userpostid||' AND EXTRACT(YEAR FROM r.createDate) = '||keyword ;
--                         
--                                    if (_orderby !='')  THEN 
--                   
--                                       _query := _query||' order by '||_orderby;
--                                       if (_order !='')  THEN 
--
--                                           _query := _query||' '||_order;
--                                           if (_offset >=0)  THEN 
--
--                                                _query := _query||' offset '||_offset;
--                                               if (_limit >0)  THEN 
--                                                   _query := _query||' limit '||_limit;
--
--                                                  
--                                                end if;
--                                      
--                                   
--                                    end if;
--                            
--                                end if;
--                           
--                            end if;
--                       
--                            
--                       end if;
--                       
--                        if (_orderby !='')  THEN 
--                   
--                                       _query := _query||' order by '||_orderby;
--                                       if (_order !='')  THEN 
--
--                                           _query := _query||' '||_order;
--                                           if (_offset >=0)  THEN 
--
--                                                _query := _query||' offset '||_offset;
--                                               if (_limit >0)  THEN 
--                                                   _query := _query||' limit '||_limit;
--
--                                                  
--                                                end if;
--                                      
--                                   
--                                    end if;
--                            
--                                end if;
--                           
--                            end if;
--                       
--               
--               end if;
--         return query execute _query;
--            
--    end;
--    
--
--$BODY$;
--
--ALTER FUNCTION public.get_put_in_file_list(bigint, integer, integer, integer, text, text)
--    OWNER TO postgres;

    
   
    
    
    
    
    -- FUNCTION: public.get_file_correspondence_list_new(bigint, bigint, text, integer, integer, text, text)

-- DROP FUNCTION IF EXISTS public.get_file_correspondence_list_new(bigint, bigint, text, integer, integer, text, text);


    
CREATE OR REPLACE FUNCTION public.get_file_correspondence_list(
	_viewmode text,
	_filemovementid bigint,
	_fileid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(receiptid bigint, receiptnumber character varying, subject character varying, category text, createdate timestamp without time zone, remark character varying, viewpdfurl text, nature character varying, correspondencetype character varying, receiptmovementid bigint) 
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
 	r.nature, fc.correspondenceType as correspondenceType, fc.receiptmovementid as receiptmovementid  FROM PUBLIC.jet_process_receipt r INNER JOIN 
 PUBLIC.jet_process_filecorrreceipt as fc  ON r.receiptid = fc.receiptid';
                  
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
                _orderBy :='r.createdate';
            ELSE
                _orderBy :='r.'||orderByCol;
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
   
    
    
 -- Note List
  -- FUNCTION: public.get_all_attached_note_list(bigint, bigint)

-- DROP FUNCTION IF EXISTS public.get_all_attached_note_list(bigint, bigint);

-- FUNCTION: public.get_all_attached_note_list(bigint, bigint)

-- DROP FUNCTION IF EXISTS public.get_all_attached_note_list(bigint, bigint);

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
    _query :='SELECT n.noteid, n.signature, n.createdate,n."content" from PUBLIC.jet_process_note n LEFT join PUBLIC.jet_process_filenote
					fn on n.noteid = fn.noteid';
                    
         IF (_viewmode ='ViewModeFromSentFile') THEN
                viewmode :='<';
        END IF;
        IF (_viewmode ='' OR _viewmode IS NULL) THEN
                viewmode :='<=';
        END IF;      
                    
                    
       IF (_fileid !=0  )THEN
           _query=_query|| ' where fn.fileid ='||_fileid||' AND fn.filemovementid'||viewmode||_filemovementid;
                return query execute _query;
       			END IF;
     end;
$BODY$;

ALTER FUNCTION public.get_all_attached_note_list(text,bigint, bigint)
    OWNER TO postgres;


    
    
    
	--Select function public.get_all_attached_note_list(0,222);

    
    
    
    
    
    -- FUNCTION: public.get_attach_receipt_movement_list_count(bigint, text)

-- DROP FUNCTION IF EXISTS public.get_attach_receipt_movement_list_count(bigint, text);

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
BEGIN
total :=0;      
      
        
        IF receipt_id !=0 AND receipt_id IS NOT NULL THEN 
            
            
            IF  keyword !='' AND keyword IS NOT NULL  THEN
   
            
 SELECT 
	count(*) into total
	FROM PUBLIC.jet_process_receiptmovement as rm 
	left outer JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
    left outer JOIN PUBLIC.masterdata_userpost as up1 ON rm.receiverid = up1.userpostid 
	left outer JOIN PUBLIC.masterdata_userpost as up2 ON rm.senderid = up2.userpostid WHERE  rm.receiptid =receipt_id  AND rm.movementtype != 0 AND active_ = true
     AND (filenumber ilike '%'||keyword||'%' OR subject ilike '%'||keyword||'%' OR  categoryvalue ilike '%'||keyword||'%') ;       
            
            return total;
            END IF;
             
            SELECT 
            count(*) into total
            FROM PUBLIC.jet_process_receiptmovement as rm 
            left outer JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
            left outer JOIN PUBLIC.masterdata_userpost as up1 ON rm.receiverid = up1.userpostid 
            left outer JOIN PUBLIC.masterdata_userpost as up2 ON rm.senderid = up2.userpostid
            WHERE  rm.receiptid =receipt_id  AND rm.movementtype != 0 AND active_ = true;
            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_attach_receipt_movement_list_count(bigint, text)
    OWNER TO postgres;

    
    
    
    
    
    -- FUNCTION: public.get_attach_receipt_movement_list(bigint, text, integer, integer, text, text)

-- DROP FUNCTION IF EXISTS public.get_attach_receipt_movement_list(bigint, text, integer, integer, text, text);

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

    

