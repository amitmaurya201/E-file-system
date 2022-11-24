-- --------------------------------------------------------
-- Host:                         localhost
-- Server version:               PostgreSQL 14.4, compiled by Visual C++ build 1914, 64-bit
-- Server OS:                    
-- HeidiSQL Version:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES  */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

-- Dumping structure for table public.md_basichead
DROP TABLE IF EXISTS "md_basichead";
CREATE TABLE IF NOT EXISTS "md_basichead" (
	"basicheadid" BIGINT NOT NULL,
	"basicheadvalue" VARCHAR NULL DEFAULT NULL,
	"basicheadcode" VARCHAR NULL DEFAULT NULL,
	PRIMARY KEY ("basicheadid")
);

-- Dumping data for table public.md_basichead: 14 rows
/*!40000 ALTER TABLE "md_basichead" DISABLE KEYS */;
INSERT INTO "md_basichead" ("basicheadid", "basicheadvalue", "basicheadcode") VALUES
	(1, 'Establishment', 'A'),
	(2, 'Welfare', 'B'),
	(3, 'Vigilance', 'C'),
	(4, 'Common Office Services', 'D'),
	(5, 'Hindi', 'E'),
	(6, 'Public Relations', 'F'),
	(7, 'Finance, Budget, Cash and Accounts', 'G'),
	(9, 'Training', 'T'),
	(10, 'Information Acts', 'I'),
	(11, 'मुमंस', 'CMO'),
	(12, 'महाराष्ट्र शासन', 'MH'),
	(16, 'सामान्य शाखा', 'GEN'),
	(17, 'वित्त विभाग', 'MFD'),
	(20, 'Tourism and Cultural Affairs', 'TCA');
/*!40000 ALTER TABLE "md_basichead" ENABLE KEYS */;

-- Dumping structure for table public.md_category
DROP TABLE IF EXISTS "md_category";
CREATE TABLE IF NOT EXISTS "md_category" (
	"categorydataid" BIGINT NOT NULL,
	"categoryvalue" VARCHAR NULL DEFAULT NULL,
	PRIMARY KEY ("categorydataid")
);

-- Dumping data for table public.md_category: 10 rows
/*!40000 ALTER TABLE "md_category" DISABLE KEYS */;
INSERT INTO "md_category" ("categorydataid", "categoryvalue") VALUES
	(1, 'Obtaining of all sanction on file including retirement benifit, loans and advances GPF etc'),
	(2, 'Deparmental Security Instructions including Access Control System'),
	(3, 'Framing of Recruitment Rules'),
	(4, 'ACP and other related matters'),
	(5, 'Conduct Rules, Intimation'),
	(6, 'ACR related matters'),
	(7, 'Appointment and other related matters of Planning Comission'),
	(8, 'Training related matters'),
	(9, 'Foreign Deputation'),
	(10, 'Annual Property Return');
/*!40000 ALTER TABLE "md_category" ENABLE KEYS */;

-- Dumping structure for table public.md_country
DROP TABLE IF EXISTS "md_country";
CREATE TABLE IF NOT EXISTS "md_country" (
	"countryid" BIGINT NOT NULL,
	"countryvalue" VARCHAR NULL DEFAULT NULL,
	"countrycode" VARCHAR NULL DEFAULT NULL,
	PRIMARY KEY ("countryid")
);

-- Dumping data for table public.md_country: 1 rows
/*!40000 ALTER TABLE "md_country" DISABLE KEYS */;
INSERT INTO "md_country" ("countryid", "countryvalue", "countrycode") VALUES
	(1, 'India', 'IN');
/*!40000 ALTER TABLE "md_country" ENABLE KEYS */;

-- Dumping structure for table public.md_deliverymode
DROP TABLE IF EXISTS "md_deliverymode";
CREATE TABLE IF NOT EXISTS "md_deliverymode" (
	"deliverymodeid" BIGINT NOT NULL,
	"deliverymodevalue" VARCHAR NULL DEFAULT NULL,
	PRIMARY KEY ("deliverymodeid")
);

-- Dumping data for table public.md_deliverymode: 26 rows
/*!40000 ALTER TABLE "md_deliverymode" DISABLE KEYS */;
INSERT INTO "md_deliverymode" ("deliverymodeid", "deliverymodevalue") VALUES
	(1, 'Fax'),
	(2, 'Speed Post'),
	(3, 'Courier'),
	(4, 'Special Messenger'),
	(5, 'Diplomatic Bag'),
	(6, 'File'),
	(7, 'By Post'),
	(8, 'Self Generated'),
	(9, 'Email'),
	(10, 'By Hand'),
	(11, 'Registered Post'),
	(12, 'हस्त बटवडा'),
	(13, 'विशेष दूत'),
	(14, 'बिनतारी संदेश'),
	(15, 'फॅक्स'),
	(16, 'पोस्ट'),
	(17, 'पार्सल'),
	(18, 'नोंदणीकृत टपाल'),
	(19, 'दूरध्वनी'),
	(20, 'तार संदेश'),
	(21, 'कुरीयर'),
	(22, 'ईमेल'),
	(23, 'SMS'),
	(24, 'संचिका'),
	(25, 'Test'),
	(26, 'TEST MODE');
/*!40000 ALTER TABLE "md_deliverymode" ENABLE KEYS */;

-- Dumping structure for table public.md_filecode
DROP TABLE IF EXISTS "md_filecode";
CREATE TABLE IF NOT EXISTS "md_filecode" (
	"filecodeid" BIGINT NOT NULL,
	"filecodevalue" VARCHAR NULL DEFAULT NULL,
	PRIMARY KEY ("filecodeid")
);

-- Dumping data for table public.md_filecode: 2 rows
/*!40000 ALTER TABLE "md_filecode" DISABLE KEYS */;
INSERT INTO "md_filecode" ("filecodeid", "filecodevalue") VALUES
	(1, 'A'),
	(2, 'B');
/*!40000 ALTER TABLE "md_filecode" ENABLE KEYS */;

-- Dumping structure for table public.md_organization
DROP TABLE IF EXISTS "md_organization";
CREATE TABLE IF NOT EXISTS "md_organization" (
	"organizationid" BIGINT NOT NULL,
	"organizationvalue" VARCHAR NULL DEFAULT NULL,
	"organizationcode" VARCHAR NULL DEFAULT NULL,
	PRIMARY KEY ("organizationid")
);

-- Dumping data for table public.md_organization: 10 rows
/*!40000 ALTER TABLE "md_organization" DISABLE KEYS */;
INSERT INTO "md_organization" ("organizationid", "organizationvalue", "organizationcode") VALUES
	(1, 'मुख्यमंत्री सचिवालय विकाक', 'मुख'),
	(2, 'आदिवासी विकास विभाग', 'आदि'),
	(3, 'cm office', 'CM '),
	(4, 'DIT Mah', 'DIT'),
	(5, 'Industry', 'IND'),
	(6, 'Medical education', 'MED'),
	(7, 'Water Resources', 'WAT'),
	(8, 'अध्यक्ष', 'अध्'),
	(9, 'Ahmadnagar', 'AHM'),
	(10, 'GAD', 'GAD');
/*!40000 ALTER TABLE "md_organization" ENABLE KEYS */;

-- Dumping structure for table public.md_primaryhead
DROP TABLE IF EXISTS "md_primaryhead";
CREATE TABLE IF NOT EXISTS "md_primaryhead" (
	"primaryheadid" BIGINT NOT NULL,
	"primaryheadvalue" VARCHAR NULL DEFAULT NULL,
	"basicheadid" BIGINT NULL DEFAULT NULL,
	PRIMARY KEY ("primaryheadid")
);

-- Dumping data for table public.md_primaryhead: 20 rows
/*!40000 ALTER TABLE "md_primaryhead" DISABLE KEYS */;
INSERT INTO "md_primaryhead" ("primaryheadid", "primaryheadvalue", "basicheadid") VALUES
	(1, 'Creation and Classification Of Posts', 1),
	(2, 'Recruitment', 1),
	(3, 'Scheduled Castes and Scheduled Tribes', 1),
	(4, 'Retrenchment', 1),
	(5, 'Verification/re-verification of character and antecedents', 1),
	(6, 'Medical examination', 2),
	(7, 'Personal files (Gazetted)', 2),
	(8, 'Personal files (Non-Gazetted)', 2),
	(9, 'Service records', 2),
	(10, 'Postings and transfers', 2),
	(11, 'Seniority', 3),
	(12, 'Leave (other than study leave and casual leave)', 3),
	(13, 'Casual leave (including special leave)', 3),
	(14, 'Pay/special pay', 3),
	(15, 'Allowances', 3),
	(16, 'Confidential/assessment report', 4),
	(17, 'Increment', 4),
	(18, 'Probation/confirmation', 4),
	(19, 'Promotion/reversion', 4),
	(20, 'Training/scholarships/fellowships India and abroad', 4);
/*!40000 ALTER TABLE "md_primaryhead" ENABLE KEYS */;

-- Dumping structure for table public.md_receiptcategory
DROP TABLE IF EXISTS "md_receiptcategory";
CREATE TABLE IF NOT EXISTS "md_receiptcategory" (
	"receiptcategorydataid" BIGINT NOT NULL,
	"receiptcategoryvalue" VARCHAR NULL DEFAULT NULL,
	PRIMARY KEY ("receiptcategorydataid")
);

-- Dumping data for table public.md_receiptcategory: 10 rows
/*!40000 ALTER TABLE "md_receiptcategory" DISABLE KEYS */;
INSERT INTO "md_receiptcategory" ("receiptcategorydataid", "receiptcategoryvalue") VALUES
	(1, 'Obtaining of all sanction on file including retirement benifit, loans and advances GPF etc'),
	(2, 'Deparmental Security Instructions including Access Control System'),
	(3, 'Framing of Recruitment Rules'),
	(4, 'ACP and other related matters'),
	(5, 'Conduct Rules, Intimation'),
	(6, 'ACR related matters'),
	(7, 'Appointment and other related matters of Planning Comission'),
	(8, 'Training related matters'),
	(9, 'Foreign Deputation'),
	(10, 'Annual Property Return');
/*!40000 ALTER TABLE "md_receiptcategory" ENABLE KEYS */;

-- Dumping structure for table public.md_receiptsubcategory
DROP TABLE IF EXISTS "md_receiptsubcategory";
CREATE TABLE IF NOT EXISTS "md_receiptsubcategory" (
	"receiptsubcategorydataid" BIGINT NOT NULL,
	"receiptsubcategoryvalue" VARCHAR NULL DEFAULT NULL,
	"receiptcategorydataid" BIGINT NULL DEFAULT NULL,
	PRIMARY KEY ("receiptsubcategorydataid")
);

-- Dumping data for table public.md_receiptsubcategory: 50 rows
/*!40000 ALTER TABLE "md_receiptsubcategory" DISABLE KEYS */;
INSERT INTO "md_receiptsubcategory" ("receiptsubcategorydataid", "receiptsubcategoryvalue", "receiptcategorydataid") VALUES
	(1, 'Interest Free', 1),
	(2, 'Interest Bearing', 1),
	(3, 'GPF Advance', 1),
	(4, 'GPF Withdrawal', 1),
	(5, 'Conversion of Advance to Withdrawal', 1),
	(6, 'Heart Treatment', 2),
	(7, 'Heart Operation', 2),
	(8, 'Kidney Operation', 2),
	(9, 'Kidney Treatment', 2),
	(10, 'Dialysis', 2),
	(11, 'Cancer', 3),
	(12, 'Medical Treatment', 3),
	(13, 'Cochlear implant', 3),
	(14, 'Brain Treatment', 3),
	(15, 'नियुक्ती', 3),
	(16, 'पदोन्नती', 4),
	(17, 'बदली', 4),
	(18, 'विभागीय चौकशी', 4),
	(19, 'वैदयकीय तपासणी', 4),
	(20, 'सेवानिवृत्ती प्रदाने', 4),
	(21, 'गट विमा योजना', 5),
	(22, 'स्वग्राम', 5),
	(23, 'जात प्रमाणपत्र पडताळणी', 5),
	(24, 'परिक्षा', 5),
	(25, 'जनगणना', 5),
	(26, 'निवडणूक', 6),
	(27, 'रजा', 6),
	(28, 'पदस्थापना', 6),
	(29, 'हजेरीपट', 6),
	(30, 'अपील', 6),
	(31, 'अर्ज', 7),
	(32, 'अर्थसंकल्प', 7),
	(33, 'पुरवणी मागणी', 7),
	(34, 'अर्थसंकल्पीय भाषण', 7),
	(35, 'व्यय अग्रक्रम समितीशी संबधित प्रकरणे', 7),
	(36, 'आकस्मिकता निधी', 8),
	(37, 'वैद्यकीय खर्च प्रतिपूर्ती', 8),
	(38, 'अग्रिम', 8),
	(39, 'ना परतावा', 8),
	(40, 'वेतन', 8),
	(41, 'सेवापुस्तक', 9),
	(42, 'बीले', 9),
	(43, 'प्रश्न', 9),
	(44, 'ठराव', 9),
	(45, 'लक्षवेधी', 9),
	(46, 'अर्धातास चर्चा', 10),
	(47, 'लोकलेखासमिती', 10),
	(48, 'समिती कामकाज', 10),
	(49, 'All dgp', 10),
	(50, 'All add.dgp', 10);
/*!40000 ALTER TABLE "md_receiptsubcategory" ENABLE KEYS */;

-- Dumping structure for table public.md_secondaryhead
DROP TABLE IF EXISTS "md_secondaryhead";
CREATE TABLE IF NOT EXISTS "md_secondaryhead" (
	"secondaryheadid" BIGINT NOT NULL,
	"secondaryheadvalue" VARCHAR NULL DEFAULT NULL,
	"primaryheadid" BIGINT NULL DEFAULT NULL,
	PRIMARY KEY ("secondaryheadid")
);

-- Dumping data for table public.md_secondaryhead: 50 rows
/*!40000 ALTER TABLE "md_secondaryhead" DISABLE KEYS */;
INSERT INTO "md_secondaryhead" ("secondaryheadid", "secondaryheadvalue", "primaryheadid") VALUES
	(1, 'Conversion Of Temporary Posts into Permanent Ones', 1),
	(2, 'Creation of Posts', 1),
	(3, 'Revision of scales of pay', 1),
	(4, 'Upgrading of posts', 1),
	(5, 'Re-designation of Posts', 1),
	(6, 'Plan/non-Plan posts', 2),
	(7, 'Recruitment (general aspects) including provisions of Constitution', 2),
	(8, 'Appointment of dependents of deceased employees', 2),
	(9, 'Appointment of honorary workers', 2),
	(10, 'Appointment of non-Indians', 2),
	(11, 'Estimate (annual) of vacancies', 3),
	(12, 'Employment priorities and maintenance of roster', 3),
	(13, 'UPSC (Exemption from Consultation) Regulations ', 3),
	(14, 'Framing of recruitment rules', 3),
	(15, 'Notification to and release of vacancies by (i) Local employment exchange and (ii) D.G.E. and T.', 3),
	(16, 'Nomination of candidates by local employment exchange and their selection', 4),
	(17, 'Recuritment through Employment exchange (general aspects)', 4),
	(18, 'Recruitment through Ministry of Personnel, Public Grievances and Pensions', 4),
	(19, 'Recruitment by Ministries', 4),
	(20, 'Recruitment from open market including advertisement and inviting of applications', 4),
	(21, 'Recruitment through UPSC including requisitions for recruitment and recommendations of UPSC', 5),
	(22, 'Recruitment otherwise than through UPSC', 5),
	(23, 'Reservation in services SC/ST/Others', 5),
	(24, 'Return regarding appointment and promotion made without consultation with UPSC', 5),
	(25, 'Selection Committees for recruitment of personnel (a) Constitution and (b) Proceedings', 5),
	(26, 'Relaxation of age/educational qualifications', 6),
	(27, 'Condonation of break in service', 6),
	(28, 'Engagement of casual labour', 6),
	(29, 'Representation in posts and services', 6),
	(30, 'Reservation Vacancies(grouping of posts, and exclusion of posts from reservation order)', 6),
	(31, 'De-reservation of vacancies', 7),
	(32, 'Complaints from associations regarding non-observance of reservation in services', 7),
	(33, 'Annual statement regarding representation of SC/ST', 7),
	(34, 'General principles', 7),
	(35, 'Group A', 7),
	(36, 'Group B', 8),
	(37, 'Group B (Non-Gazetted)', 8),
	(38, 'Group C', 8),
	(39, 'Group D', 8),
	(40, 'Rules (General aspects)', 8),
	(41, 'Group A', 9),
	(42, 'Group B', 9),
	(43, 'Group B (non-gazetted)', 9),
	(44, 'Group C', 9),
	(45, 'Group D', 9),
	(46, 'Rules (General aspects)', 10),
	(47, 'Group A', 10),
	(48, 'Group B', 10),
	(49, 'Group B (non-gazetted)', 10),
	(50, 'Group C', 10);
/*!40000 ALTER TABLE "md_secondaryhead" ENABLE KEYS */;

-- Dumping structure for table public.md_state
DROP TABLE IF EXISTS "md_state";
CREATE TABLE IF NOT EXISTS "md_state" (
	"stateid" BIGINT NOT NULL,
	"statecode" VARCHAR NULL DEFAULT NULL,
	"statevalue" VARCHAR NULL DEFAULT NULL,
	"countryid" BIGINT NULL DEFAULT NULL,
	PRIMARY KEY ("stateid")
);

-- Dumping data for table public.md_state: 35 rows
/*!40000 ALTER TABLE "md_state" DISABLE KEYS */;
INSERT INTO "md_state" ("stateid", "statecode", "statevalue", "countryid") VALUES
	(1, 'AN', 'Andaman and Nicobar Islands', 1),
	(2, 'AP', 'Andhra Pradesh', 1),
	(3, 'AR', 'Arunachal Pradesh', 1),
	(4, 'AS', 'Assam', 1),
	(5, 'BR', 'Bihar', 1),
	(6, 'CH', 'Chandigarh', 1),
	(7, 'CT', 'Chhattisgarh', 1),
	(8, 'DH', 'Dadra and Nagar Haveli and Daman and Diu', 1),
	(9, 'DL', 'Delhi', 1),
	(10, 'GA', 'Goa', 1),
	(11, 'GJ', 'Gujarat', 1),
	(12, 'HR', 'Haryana', 1),
	(13, 'HP', 'Himachal Pradesh', 1),
	(14, 'JK', 'Jammu and Kashmir', 1),
	(15, 'JH', 'Jharkhand', 1),
	(16, 'KA', 'Karnataka', 1),
	(17, 'KL', 'Kerala', 1),
	(18, 'LA', 'Ladakh', 1),
	(19, 'LD', 'Lakshadweep', 1),
	(20, 'MP', 'Madhya Pradesh', 1),
	(21, 'MH', 'Maharashtra', 1),
	(22, 'MN', 'Manipur', 1),
	(23, 'ML', 'Meghalaya', 1),
	(24, 'MZ', 'Mizoram', 1),
	(25, 'NL', 'Nagaland', 1),
	(26, 'OR', 'Odisha', 1),
	(27, 'PY', 'Puducherry', 1),
	(28, 'PB', 'Punjab', 1),
	(29, 'RJ', 'Rajasthan', 1),
	(30, 'SK', 'Sikkim', 1),
	(31, 'TN', 'Tamil Nadu', 1),
	(32, 'TG', 'Telangana', 1),
	(33, 'TR', 'Tripura', 1),
	(34, 'UP', 'Uttar Pradesh', 1),
	(35, 'WB', 'West Bengal', 1);
/*!40000 ALTER TABLE "md_state" ENABLE KEYS */;

-- Dumping structure for table public.md_subcategory
DROP TABLE IF EXISTS "md_subcategory";
CREATE TABLE IF NOT EXISTS "md_subcategory" (
	"subcategoryid" BIGINT NOT NULL,
	"subcategoryvalue" VARCHAR NULL DEFAULT NULL,
	"categorydataid" BIGINT NULL DEFAULT NULL,
	PRIMARY KEY ("subcategoryid")
);

-- Dumping data for table public.md_subcategory: 50 rows
/*!40000 ALTER TABLE "md_subcategory" DISABLE KEYS */;
INSERT INTO "md_subcategory" ("subcategoryid", "subcategoryvalue", "categorydataid") VALUES
	(1, 'Interest Free', 1),
	(2, 'Interest Bearing', 1),
	(3, 'GPF Advance', 1),
	(4, 'GPF Withdrawal', 1),
	(5, 'Conversion of Advance to Withdrawal', 1),
	(6, 'Heart Treatment', 2),
	(7, 'Heart Operation', 2),
	(8, 'Kidney Operation', 2),
	(9, 'Kidney Treatment', 2),
	(10, 'Dialysis', 2),
	(11, 'Cancer', 3),
	(12, 'Medical Treatment', 3),
	(13, 'Cochlear implant', 3),
	(14, 'Brain Treatment', 3),
	(15, 'नियुक्ती', 3),
	(16, 'पदोन्नती', 4),
	(17, 'बदली', 4),
	(18, 'विभागीय चौकशी', 4),
	(19, 'वैदयकीय तपासणी', 4),
	(20, 'सेवानिवृत्ती प्रदाने', 4),
	(21, 'गट विमा योजना', 5),
	(22, 'स्वग्राम', 5),
	(23, 'जात प्रमाणपत्र पडताळणी', 5),
	(24, 'परिक्षा', 5),
	(25, 'जनगणना', 5),
	(26, 'निवडणूक', 6),
	(27, 'रजा', 6),
	(28, 'पदस्थापना', 6),
	(29, 'हजेरीपट', 6),
	(30, 'अपील', 6),
	(31, 'अर्ज', 7),
	(32, 'अर्थसंकल्प', 7),
	(33, 'पुरवणी मागणी', 7),
	(34, 'अर्थसंकल्पीय भाषण', 7),
	(35, 'व्यय अग्रक्रम समितीशी संबधित प्रकरणे', 7),
	(36, 'आकस्मिकता निधी', 8),
	(37, 'वैद्यकीय खर्च प्रतिपूर्ती', 8),
	(38, 'अग्रिम', 8),
	(39, 'ना परतावा', 8),
	(40, 'वेतन', 8),
	(41, 'सेवापुस्तक', 9),
	(42, 'बीले', 9),
	(43, 'प्रश्न', 9),
	(44, 'ठराव', 9),
	(45, 'लक्षवेधी', 9),
	(46, 'अर्धातास चर्चा', 10),
	(47, 'लोकलेखासमिती', 10),
	(48, 'समिती कामकाज', 10),
	(49, 'All dgp', 10),
	(50, 'All add.dgp', 10);
/*!40000 ALTER TABLE "md_subcategory" ENABLE KEYS */;

-- Dumping structure for table public.md_suborganization
DROP TABLE IF EXISTS "md_suborganization";
CREATE TABLE IF NOT EXISTS "md_suborganization" (
	"suborganizationid" BIGINT NOT NULL,
	"suborganizationvalue" VARCHAR NULL DEFAULT NULL,
	"organizationid" BIGINT NULL DEFAULT NULL,
	PRIMARY KEY ("suborganizationid")
);

-- Dumping data for table public.md_suborganization: 8 rows
/*!40000 ALTER TABLE "md_suborganization" DISABLE KEYS */;
INSERT INTO "md_suborganization" ("suborganizationid", "suborganizationvalue", "organizationid") VALUES
	(1, 'National Centre for Integrated Pest Management', 1),
	(2, 'National Horticulture Board (NHB)', 1),
	(3, 'National Dairy Development Board (NDDB)', 2),
	(4, 'Indian Council of Agricultural Research (ICAR)', 2),
	(5, 'Directorate General of Civil Aviation', 3),
	(6, 'Bureau of Civil Aviation Security', 3),
	(7, 'Airports Authority of India', 4),
	(8, 'Indira Gandhi Rashtriya Uran Academy', 4);
/*!40000 ALTER TABLE "md_suborganization" ENABLE KEYS */;

-- Dumping structure for table public.md_tertiaryhead
DROP TABLE IF EXISTS "md_tertiaryhead";
CREATE TABLE IF NOT EXISTS "md_tertiaryhead" (
	"tertiaryheadid" BIGINT NOT NULL,
	"tertiaryheadvalue" VARCHAR NULL DEFAULT NULL,
	"secondaryheadid" BIGINT NULL DEFAULT NULL,
	PRIMARY KEY ("tertiaryheadid")
);

-- Dumping data for table public.md_tertiaryhead: 20 rows
/*!40000 ALTER TABLE "md_tertiaryhead" DISABLE KEYS */;
INSERT INTO "md_tertiaryhead" ("tertiaryheadid", "tertiaryheadvalue", "secondaryheadid") VALUES
	(1, 'Medicine purchase in emergency', 1),
	(2, 'Medicines purchase for medical centre from authorized chemist', 1),
	(3, 'Medicines purchased from GMSD karnal', 1),
	(4, 'Medicines purchase from chronic patients', 2),
	(5, 'Medicines purchase for trekking and village visit', 2),
	(6, 'Medicines purchase for Phase III/IV/V', 2),
	(7, 'Purchase of Lab. Reagents', 3),
	(8, 'Purchase of X-Ray films and chemicals', 3),
	(9, 'Purchase of misc. items for medical centre', 3),
	(10, 'Purchase of instruments and other equipments', 4),
	(11, 'Dispensary Staff Correspondence', 4),
	(12, 'Meetings related to Medical Centre', 4),
	(13, 'Bio Waste Management', 5),
	(14, 'Water analysis', 5),
	(15, 'Repair of machines & equipments', 5),
	(16, 'AMC related to equipments in Medical Centre', 6),
	(17, 'Medical facilities from medical centre', 6),
	(18, 'Audit', 6),
	(19, 'Re Filings of O2', 7),
	(20, 'Other misc. issue related to medical centre', 7);
/*!40000 ALTER TABLE "md_tertiaryhead" ENABLE KEYS */;

-- Dumping structure for table public.md_type
DROP TABLE IF EXISTS "md_type";
CREATE TABLE IF NOT EXISTS "md_type" (
	"typeid" BIGINT NOT NULL,
	"typevalue" VARCHAR NULL DEFAULT NULL,
	PRIMARY KEY ("typeid")
);

-- Dumping data for table public.md_type: 10 rows
/*!40000 ALTER TABLE "md_type" DISABLE KEYS */;
INSERT INTO "md_type" ("typeid", "typevalue") VALUES
	(1, 'Demi-official Letter'),
	(2, 'Interim Reply'),
	(3, 'Acknowledgement'),
	(4, 'Letter'),
	(5, 'Circular'),
	(6, 'Note'),
	(7, 'U.O. Note'),
	(8, 'Informal'),
	(9, 'Interim Reply 2'),
	(10, 'Interim Reply 3');
/*!40000 ALTER TABLE "md_type" ENABLE KEYS */;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
