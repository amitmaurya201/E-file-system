
-- ---------------------File created list count  --------------------------


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
            
            
            IF post_id !=0 AND post_id IS NOT NULL AND  keyword !='' AND keyword IS NOT NULL  THEN
   
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


    
--    --------------------- File inbox list count -------------------------

    
    CREATE OR REPLACE FUNCTION public.get_file_inbox_lists_count(
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
            
            
            IF sender_id !=0 AND sender_id IS NOT NULL AND  keyword !='' AND keyword IS NOT NULL  THEN
   
           
        SELECT count(*) into total
		FROM PUBLIC.jet_process_filemovement as fm 
        Join (select max(mov.fmid) as mfmId from PUBLIC.jet_process_filemovement mov where mov.active_ = true group by mov.fileId) fmov on fmov.mfmId = fm.fmid  
		  JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
		 JOIN PUBLIC.masterdata_userpost as up1 ON fm.senderid = up1.userpostid
		 JOIN PUBLIC.masterdata_userpost as up2
		ON fm.receiverid = up2.userpostid 
	    where fm.receiverid = 1 AND fm.pullbackremark is null AND  (f.filenumber ilike '%'||keyword||'%' OR f.subject ilike '%'||keyword||'%') ;       
            
            return total;
            END IF;
                
        SELECT count(*) into total
		FROM PUBLIC.jet_process_filemovement as fm 
        Join (select max(mov.fmid) as mfmId from PUBLIC.jet_process_filemovement mov where mov.active_ = true group by mov.fileId) fmov on fmov.mfmId = fm.fmid  
		  JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
		 JOIN PUBLIC.masterdata_userpost as up1 ON fm.senderid = up1.userpostid
		 JOIN PUBLIC.masterdata_userpost as up2
		ON fm.receiverid = up2.userpostid 
	    where fm.receiverid = 1;

			

            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_file_inbox_lists_count(bigint, text)
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
            
            
            IF sender_id !=0 AND sender_id IS NOT NULL AND  keyword !='' AND keyword IS NOT NULL  THEN
   
           SELECT count(*) into total
					FROM PUBLIC.jet_process_filemovement as fm 
					JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid
					JOIN PUBLIC.masterdata_userpost as up1 ON fm.receiverid = up1.userpostid 
					where fm.senderid = sender_id AND currentstate = 2  AND fm.active_ = true
                    AND fm.pullbackremark is null AND  (f.filenumber ilike '%'||keyword||'%' OR f.subject ilike '%'||keyword||'%') ;       
            
            return total;
            END IF;
                SELECT count(*) into total
					FROM PUBLIC.jet_process_filemovement as fm 
					JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid
					JOIN PUBLIC.masterdata_userpost as up1 ON fm.receiverid = up1.userpostid 
					where fm.senderid = sender_id AND currentstate = 2  AND fm.active_ = true AND fm.pullbackremark is null;
			

            RETURN total;
        END IF;

        RETURN total;
END;
$BODY$;

ALTER FUNCTION public.get_file_sent_lists_count(bigint, text)
    OWNER TO postgres;



-- ------------------------  Get File List  -----------------------------


CREATE OR REPLACE FUNCTION public.get_file_created_list(
	post_id bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(docfileid bigint, filenumber character varying, subject character varying, category character varying, remark character varying, createdon timestamp without time zone, nature character varying) 
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
      
      _offset :=0;
     _limit :=4;
     _offset :=_start;
     _limit :=_end;
     orderBy :=orderByCol;
     _order :=_orderByType;
      _keyword := '''%'||keyword||'%''';
      _query := 'Select  docfileid as docfileid, filenumber as filenumber , subject as subject , categoryvalue as category ,
                        remarks as remark  , createDate as createdOn ,  nature as nature
                        FROM public.jet_process_docfile  INNER JOIN public.md_category 
                        ON categorydataid = categoryid
                        where currentstate = 1 ';
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
                orderBy :='createdate';
            ELSE
                orderBy :=orderByCol;
        END IF;
         IF (_orderByType ='' OR _orderByType IS NULL) THEN
                _order :='desc';
            ELSE
                _order :=_orderByType;
        END IF;
       
       
                        
                        IF post_id !=0 THEN
                        
                             _query := _query|| ' AND userpostid = '||post_id;
                            
                               if keyword IS NOT NULL THEN
                
                                     _query := _query||  'AND (filenumber ilike'|| _keyword ||'OR subject ilike'|| _keyword ||'OR  categoryvalue ilike'|| _keyword ||')';
                          
                                     if orderby !=''  THEN 
                    
                                        _query := _query||' order by '||orderby;
                                        if _order !=''  THEN 

                                            _query := _query||' '||_order;
                                            if _offset >=0  THEN 

                                                 _query := _query||' offset '||_offset;
                                                if _limit >0  THEN 
                                                    _query := _query||' limit '||_limit;

                                                    else
                                                    _query := _query||' limit '||_offset;
                                                 end if;
                                        ELSE
                                        _query := _query||' offset '||_offset ||' limit '||_offset;
                                    
                                     end if;
                                  ELSE
                               IF _offset >=0 THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||_offset||' limit '||_limit;
                                       END IF;
                                 end if;
                                ELSE
                              IF _offset >=0 THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||_offset||' limit '||_limit;
                                       END IF;
                            
                             end if;
                        
                             return query execute _query;
                             end if;
                        
                        
                 else
                     return query execute _query;
                
                end if;
         
             
     end;
     
 
$BODY$;

ALTER FUNCTION public.get_file_created_list(bigint, text, integer, integer, text, text)
    OWNER TO postgres;
    
    
    

--  -----------------------  Get File Inbox List  ----------------------------------

    CREATE OR REPLACE FUNCTION public.get_file_inbox_list(
	receiverid bigint,
	keyword text,
	_start integer,
	_end integer,
	orderbycol text,
	_orderbytype text)
    RETURNS TABLE(filemovementid bigint, filenumber character varying, subject character varying, sentby text, sentto text, senton timestamp without time zone, readon character varying, duedate character varying, remark character varying, receivedon character varying, currentlywith bigint, nature character varying, fileid bigint, senderid bigint, currentstate integer, docfileid bigint, pullbackremark character varying) 
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
		(SELECT concat(up1.username,(  up1.postmarking) , up1.sectionname, up1.departmentname)) as sentBy,
		(SELECT concat(up2.username, up2.postmarking, up2.sectionname, up2.departmentname)) AS SentTo ,
		fm.createdate as sentOn, fm.readon as readOn, fm.duedate as dueDate, fm.remark as remark, fm.receivedon as receivedOn,
		f.currentlywith as currentlyWith, f.nature as nature, f.docfileid as fileId, fm.senderid as senderId , 
        f.currentstate as currentState , f.docfileid as docFileId , fm.pullbackremark as pullBackRemark
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

                                                    else
                                                    _query := _query||' limit 4';
                                                 end if;
                                        ELSE
                                        _query := _query||' offset '||0 ||' limit 4';
                                    
                                     end if;
                                  ELSE
                               IF (_offset >=0) THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||0||' limit '||_limit;
                                       END IF;
                                 end if;
                                ELSE
                              IF (_offset >=0) THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||0||' limit '||_limit;
                                       END IF;
                            
                             end if;
                        
                             return query execute _query;
                             end if;
                        
                        
                 else
                     return query execute _query;
                
                end if;
         
             
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
    RETURNS TABLE(filemovementid bigint, filenumber character varying, subject character varying, sentby text, sentto text, senton timestamp without time zone, readon character varying, duedate character varying, remark text, receivedon character varying, currentlywith bigint, nature character varying, fileid bigint, senderid integer, currentstate integer, docfileid bigint, pullbackremark character varying) 
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
			null as sendBy, (SELECT concat(up1.username, up1.postmarking , up1.sectionname , up1.departmentname)) AS sentTo ,
			fm.createdate as SentOn, fm.readon as readOn, fm.duedate , null as remark, fm.receivedon as receivedOn , f.currentlywith as currentlyWith , f.nature as nature , f.docfileid as fileId , 0 as senderid , f.currentstate as currentState , f.docfileid as docFileId , fm.pullbackremark as pullBackRemark
			FROM PUBLIC.jet_process_filemovement as fm 
			JOIN PUBLIC.jet_process_docfile as f ON fm.fileId = f.docfileid        
			JOIN PUBLIC.masterdata_userpost as up1 ON fm.receiverid = up1.userpostid 
			where currentstate = 2  AND fm.active_ = true 
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
       
                        
                        IF (_senderid !=0 )THEN
                        
                             _query := _query|| ' AND fm.senderid ='||_senderid;
                            
                               if (keyword IS NOT NULL) THEN  
                                                                
                                     _query := _query||' AND (f.filenumber ilike '||_keyword ||' OR f.subject ilike '||_keyword ||')';
                          
                                     if (_orderby !='')  THEN 
                    
                                        _query := _query||' order by '||_orderby;
                                        if (_order !='')  THEN 

                                            _query := _query||' '||_order;
                                            if (_offset >=0)  THEN 

                                                 _query := _query||' offset '||_offset;
                                                if (_limit >0)  THEN 
                                                    _query := _query||' limit '||_limit;

                                                    else
                                                    _query := _query||' limit 4';
                                                 end if;
                                        ELSE
                                        _query := _query||' offset '||0 ||' limit 4';
                                    
                                     end if;
                                  ELSE
                               IF (_offset >=0) THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||0||' limit '||_limit;
                                       END IF;
                                 end if;
                                ELSE
                              IF (_offset >=0) THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||0||' limit '||_limit;
                                       END IF;
                            
                             end if;
                        
                             return query execute _query;
                             end if;
                        
                        
                 else
                     return query execute _query;
                
                end if;
         
             
     end;
     
 
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
            
            
            IF post_id !=0 AND post_id IS NOT NULL AND  keyword !='' AND keyword IS NOT NULL  THEN
   
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

ALTER FUNCTION public.get_receipt_created_list_count(bigint,text)
    OWNER TO postgres;
    
    
--    ------------------------------------- Get Receipt Inbox List Count -------------------------------------------

    
   CREATE OR REPLACE FUNCTION public.get_receipt_inbox_list_count(
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
            
            
            IF post_id !=0 AND post_id IS NOT NULL AND  keyword !='' AND keyword IS NOT NULL  THEN
   
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
            
            
            IF post_id !=0 AND post_id IS NOT NULL AND  keyword !='' AND keyword IS NOT NULL  THEN
   
                 SELECT count(*) into total
                 FROM PUBLIC.jet_process_receiptmovement as rm 
                 JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
                 JOIN PUBLIC.masterdata_userpost as up ON rm.receiverid = up.userpostid
                 where rm.senderid = post_id and rm.active_ = true and rm.pullbackremark
                 is null AND (r.receiptnumber ilike '%'||keyword||'%' OR r.subject ilike '%'||keyword||'%') ;       
                                    
            return total; 
            END IF;
                SELECT count(*) into total
		        FROM PUBLIC.jet_process_receiptmovement as rm 
		        JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
		        JOIN PUBLIC.masterdata_userpost as up ON rm.receiverid = up.userpostid
                where rm.senderid = post_id and rm.active_ = true and rm.pullbackremark is null;
            RETURN total;
        END IF;

        RETURN total;
      end;
  
$BODY$;

ALTER FUNCTION public.get_receipt_sent_list_count(bigint,text)
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
                _orderBy :='createdate';
            ELSE
                _orderBy :=orderByCol;
        END IF;
          IF (_orderByType ='' OR _orderByType IS NULL) THEN
                _order :='desc';
            ELSE
                _order :=orderByCol;
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

                                                    else
                                                    _query := _query||' limit 4';
                                                 end if;
                                            ELSE
                                        _query := _query||' offset '||0 ||' limit 4';
                                    
                                     end if;
                                 
                                 ELSE
                                 
                                    IF _offset >=0 THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||0||' limit '||_limit;
                                       END IF;
                                 end if;
                                ELSE
                               IF _offset >=0 THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||0||' limit '||_limit;
                                       END IF;
                            
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
    RETURNS TABLE(receiptmovementid bigint, receiptnumber character varying, subject character varying, sender text, sentby text, sentto text, senton timestamp without time zone, readon character varying, duedate character varying, remark character varying, receiveon character varying, nature character varying, receiptid bigint, pullbackremark character varying) 
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
                (SELECT concat(up1.username,  up1.postmarking, up1.sectionname , up1.departmentname)) as sentBy,
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
                _orderBy :='rm.createdate';
            ELSE
                _orderBy :='r.'||orderByCol;
        END IF;
         IF (_orderByType ='' OR _orderByType IS NULL) THEN
                _order :='desc';
            ELSE
                _order :=_orderByType;
        END IF;
       
                        
                        IF (receiverid !=0 )THEN
                        
                             _query := _query|| '  AND rm.receiverid  ='||receiverid;
                            
                               if (keyword IS NOT NULL) THEN
                                     _query := _query||' AND (r.receiptnumber ilike '||_keyword ||' OR r.subject ilike '||_keyword ||')';
                          
                                     if (_orderby !='')  THEN 
                    
                                        _query := _query||' order by '||_orderby;
                                        if (_order !='')  THEN 

                                            _query := _query||' '||_order;
                                            if (_offset >=0)  THEN 

                                                 _query := _query||' offset '||_offset;
                                                if (_limit >0)  THEN 
                                                    _query := _query||' limit '||_limit;

                                                    else
                                                    _query := _query||' limit 4';
                                                 end if;
                                        ELSE
                                        _query := _query||' offset '||0 ||' limit 4';
                                    
                                     end if;
                                  ELSE
                               IF (_offset >=0) THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||0||' limit '||_limit;
                                       END IF;
                                 end if;
                                ELSE
                              IF (_offset >=0) THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||0||' limit '||_limit;
                                       END IF;
                            
                             end if;
                        
                             return query execute _query;
                             end if;
                        
                        
                 else
                     return query execute _query;
                
                end if;
         
             
     end;
     
 
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
    RETURNS TABLE(receiptmovementid bigint, receiptnumber character varying, subject character varying, sender character varying, sentby text, sentto text, senton timestamp without time zone, readon character varying, duedate character varying, remark character varying, receivedon character varying, nature character varying, receiptid bigint, pullbackremark character varying) 
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
		(SELECT concat(up.username, up.postmarking , up.sectionname, up.departmentname)) as sentTo ,
		rm.createdate as sentOn, rm.readOn as readOn , rm.dueDate as dueDate , rm.remark as remark ,
        rm.receivedOn as receivedOn, r.nature as nature ,r.receiptid as receiptid , pullBackRemark as pullBackRemark
		FROM PUBLIC.jet_process_receiptmovement as rm 
		JOIN PUBLIC.jet_process_receipt as r ON rm.receiptId = r.receiptId
		JOIN PUBLIC.masterdata_userpost as up ON rm.receiverid = up.userpostid
        where rm.active_ = true and rm.pullbackremark is null ';
                  
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
                _orderBy :='rm.createdate';
            ELSE
                _orderBy :='r.'||orderByCol;
        END IF;
        IF (_orderbytype ='' OR _orderbytype IS NULL) THEN
                _order :='desc';
            ELSE
                 _order :=_orderbytype;
        END IF;
       
                        
                        IF (_senderid !=0 )THEN
                        
                             _query := _query|| ' AND rm.senderid  ='||_senderid;
                            
                               if (keyword IS NOT NULL) THEN  
                                                                
                                     _query := _query||' AND (r.receiptnumber ilike '||_keyword ||' OR r.subject ilike '||_keyword ||')';
                          
                                     if (_orderby !='')  THEN 
                    
                                        _query := _query||' order by '||_orderby;
                                        if (_order !='')  THEN 

                                            _query := _query||' '||_order;
                                            if (_offset >=0)  THEN 

                                                 _query := _query||' offset '||_offset;
                                                if (_limit >0)  THEN 
                                                    _query := _query||' limit '||_limit;

                                                    else
                                                    _query := _query||' limit 4';
                                                 end if;
                                        ELSE
                                        _query := _query||' offset '||0 ||' limit 4';
                                    
                                     end if;
                                  ELSE
                               IF (_offset >=0) THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||0||' limit '||_limit;
                                       END IF;
                                 end if;
                                ELSE
                              IF (_offset >=0) THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||0||' limit '||_limit;
                                       END IF;
                            
                             end if;
                        
                             return query execute _query;
                             end if;
                        
                        
                 else
                     return query execute _query;
                
                end if;
         
             
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
            
            
            IF user_post_id !=0 AND user_post_id IS NOT NULL AND  keyword !='' AND keyword IS NOT NULL  THEN
   
                 
                select sum (s.c) from (
                select count(*) into total as c  from
                (SELECT r.receiptid, r.receiptnumber , r.subject, ca.categoryvalue as category, r.createDate, r.remarks as remark, viewpdfurl as null, r.nature 
                FROM PUBLIC.jet_process_receipt r INNER JOIN PUBLIC.md_category ca ON ca.categorydataid = r.receiptcategoryid where r.userpostid=1 and r.attachstatus is null and r.currentstate=1
                AND (r.receiptnumber ilike '%'||keyword||'%' OR r.subject ilike '%'||keyword||'%')
                union 
                SELECT r.receiptid, r.receiptnumber , r.subject, c.categoryvalue as category, r.createDate, r.remarks as remark, viewpdfurl as null, r.nature
                FROM PUBLIC.jet_process_receipt r INNER JOIN PUBLIC.md_category c ON c.categorydataid = r.receiptcategoryid join(select rm.receiptid as rmreceiptid 
                from PUBLIC.jet_process_receiptmovement rm Join (select max(mov.rmid) as mreceiptId from PUBLIC.jet_process_receiptmovement mov where mov.active_ = true
                group by mov.receiptId) rmov on rmov.mreceiptId = rm.rmid where rm.receiverid =1) as t on t.rmreceiptid =r.receiptid
                where r.currentstate=1 and r.attachstatus is null   AND (r.receiptnumber ilike '%'||keyword||'%' OR r.subject ilike '%'||keyword||'%')) as tm
                GROUP BY receiptid) as s;
            return total;
            END IF;
                
                select sum (s.c) from (
                select count(*)  into total as c  from
                (SELECT r.receiptid, r.receiptnumber , r.subject, ca.categoryvalue as category, r.createDate, r.remarks as remark, viewpdfurl as null, r.nature 
                FROM PUBLIC.jet_process_receipt r INNER JOIN PUBLIC.md_category ca ON ca.categorydataid = r.receiptcategoryid where r.userpostid=1 and r.attachstatus is null and r.currentstate=1

                union 
                SELECT r.receiptid, r.receiptnumber , r.subject, c.categoryvalue as category, r.createDate, r.remarks as remark, viewpdfurl as null, r.nature
                FROM PUBLIC.jet_process_receipt r INNER JOIN PUBLIC.md_category c ON c.categorydataid = r.receiptcategoryid join(select rm.receiptid as rmreceiptid 
                 from PUBLIC.jet_process_receiptmovement rm Join (select max(mov.rmid) as mreceiptId from PUBLIC.jet_process_receiptmovement mov where mov.active_ = true
                 group by mov.receiptId) rmov on rmov.mreceiptId = rm.rmid where rm.receiverid =1) as t on t.rmreceiptid =r.receiptid
                 where r.currentstate=1 and r.attachstatus is null ) as tm
                 GROUP BY receiptid) as s;
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
    RETURNS TABLE(receiptid bigint, receiptnumber character varying(75), 
subject character varying, category character varying, createdate timestamp, 
remark character varying(500),  viewpdfurl character varying(1024), 
nature character varying(75)) 
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
      
      
   q1='  SELECT r.receiptid, r.receiptnumber , r.subject, ca.categoryvalue as category, r.createDate, r.remarks as remark, null as viewpdfurl , r.nature 
    FROM PUBLIC.jet_process_receipt r INNER JOIN PUBLIC.md_category ca ON ca.categorydataid = r.receiptcategoryid where r.attachstatus is null and r.currentstate=1 ';

    q2=' union 
    SELECT r.receiptid, r.receiptnumber , r.subject, c.categoryvalue as category, r.createDate, r.remarks as remark, viewpdfurl as null, r.nature
    FROM PUBLIC.jet_process_receipt r INNER JOIN PUBLIC.md_category c ON c.categorydataid = r.receiptcategoryid join(select rm.receiptid as rmreceiptid 
    from PUBLIC.jet_process_receiptmovement rm Join (select max(mov.rmid) as mreceiptId from PUBLIC.jet_process_receiptmovement mov where mov.active_ = true
    group by mov.receiptId) rmov on rmov.mreceiptId = rm.rmid ';
    
    q3:=') as t on t.rmreceiptid =r.receiptid
    where r.currentstate=1 and r.attachstatus is null  ';
    _query :=q1||q2;
                  
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
                _orderBy :='createdate';
            ELSE
                _orderBy :=orderByCol;
        END IF;
        IF (_orderbytype ='' OR _orderbytype IS NULL) THEN
                _order :='desc';
            ELSE
                 _order :=_orderbytype;
        END IF;
       
                        
                        IF (userpostid !=0 )THEN
                        
                     
                        
                             _query := q1|| ' AND r.userpostid='||userpostid||q2||' where rm.receiverid = '||userpostid||q3;
                            
                               if (keyword IS NOT NULL) THEN  
                                                                
                                     _query := q1|| ' AND r.userpostid='||userpostid||'AND (r.receiptnumber ilike '||_keyword ||' OR r.subject ilike '||_keyword ||')'||q2||' where rm.receiverid= '||userpostid||q3 ||'AND (r.receiptnumber ilike '||_keyword ||' OR r.subject ilike '||_keyword ||')';
                          
                                     if (_orderby !='')  THEN 
                    
                                        _query := _query||' order by '||_orderby;
                                        if (_order !='')  THEN 

                                            _query := _query||' '||_order;
                                            if (_offset >=0)  THEN 

                                                 _query := _query||' offset '||_offset;
                                                if (_limit >0)  THEN 
                                                    _query := _query||' limit '||_limit;

                                                    else
                                                    _query := _query||' limit 4';
                                                 end if;
                                        ELSE
                                        _query := _query||' offset '||0 ||' limit 4';
                                    
                                     end if;
                                  ELSE
                               IF (_offset >=0) THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||0||' limit '||_limit;
                                       END IF;
                                 end if;
                                ELSE
                              IF (_offset >=0) THEN
                                    _query := _query||' offset '||_offset||' limit '||_limit;
                                    ELSE
                                        _query := _query||' offset '||0||' limit '||_limit;
                                       END IF;
                            
                             end if;
                        
                             return query execute _query;
                             end if;
                        
                        
                 else
                     return query execute _query;
                
                end if;
         
             
     end;
     
 
$BODY$;

ALTER FUNCTION public.get_put_in_file_list(bigint, text, integer, integer, text, text)
    OWNER TO postgres;

    
--    -------------------------------------  Get File Movement Count  -----------------------------------------------

    
    
    
    --    -------------------------------------  Get File Movement List  -----------------------------------------------
    
    
    
    
    --    -------------------------------------  Get File Movement Count  ----------------------------------------------- 
    
    
    
    
    --    -------------------------------------  Get Receipt Movement List  -----------------------------------------------
    
    

 
 
 
    
