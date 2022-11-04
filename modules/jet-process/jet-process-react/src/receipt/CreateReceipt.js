import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { FaFileContract, FaEnvelope, FaUpload, FaWindowClose, FaFileAlt } from 'react-icons/fa';
//import ViewPdfFile  from './viewPdfFile';


const CreateReceipt = (props) => {

    //for all diary fields
    const current = new Date();
    const date = `${current.getDate()}/${current.getMonth() + 1}/${current.getFullYear()}`;
    const [type, setType] = useState("");
    const [deliveryMode, setDeliveryMode] = useState("");
    const [receivedOn, setReceivedOn] = useState("");
    const [letterDate, setLetterDate] = useState("");
    const [referenceNumber, setReferenceNumber] = useState("");
    const [modeNumber, setModeNumber] = useState("");

    //for all contact fields
    const [organization, setOrganization] = useState(0);
    const [subOrganization, setSubOrganization] = useState("");
    const [name, setName] = useState("");
    const [designation, setDesignation] = useState("");
    const [mobile, setMobile] = useState("");
    const [email, setEmail] = useState("");
    const [address, setAddress] = useState("");
    const [country, setCountry] = useState(0);
    const [state, setState] = useState("");
    const [city, setCity] = useState("");
    const [pinCode, setPinCode] = useState("");

    //for all sender fields
    const [category, setCategory] = useState(0);
    const [subCategory, setSubCategory] = useState("");
    const [subject, setSubject] = useState("");
    const [remarks, setRemarks] = useState("");
    //for file fields
    const [document, setdocument] = useState();
    // const [docPath, setDocPath] = useState();
    const [isDocPicked, setIsDocPicked] = useState(false);
     //for file fields
    
     const [fileData, setFileData] =useState();
     const [tempFileEntryId, setTempFileEntryId] = useState();
     const [viewTempFileUrl, setViewTempFileUrl] = useState();

    //for handling file change
    const groupId =Liferay.ThemeDisplay.getScopeGroupId();
    const handleSubmission = async (event) => {
        setFileData(event.target.files[0]);
        const file = event.target.files[0];
        const formData = new FormData();
		formData.append('document', file);
        formData.append('groupId', groupId); 
        axios.post(`http://localhost:8080/o/jet-process-docs/v1.0/tempFileUpload?p_auth=` + Liferay.authToken, formData, {headers:{"Content-Type" : "application/json"}
       
    })
       .then((result) => {
        console.log('Success:', result.data);
        setTempFileEntryId(result.data.id);
         setViewTempFileUrl(result.data.description);    
    }).catch((error) => {
                console.log("error happened");
				console.error('Error:', error);
			});
      
	};
    //for Master Data fields
    const [typeMData, setTypeMData] = useState([]);
    const [deliveryModeMData, setDeliveryModeMData] = useState([]);
    const [organizationMData, setOrganizationMData] = useState([]);
    const [subOrganizationMData, setsubOrganizationMData] = useState([]);
    const [categoryMData, setCategoryMData] = useState([]);
    const [subCategoryMData, setSubCategoryMData] = useState([]);
    const [countryMData, setConutryMData] = useState([]);
    const [stateMData, setStateMData] = useState([]);

    const getMasterDataValue = (e) => {
        let value = e.target.value;
        let name = e.target.name;

        if (name == 'type') {
            setType(value);
        }
        else if (name == 'deliveryMode') {
            setDeliveryMode(value);
        }
        else if (name == 'organization') {
            setOrganization(value);
        }
        else if (name == 'subOrganization') {
            setSubOrganization(value);
        }
        else if (name == 'category') {
            setCategory(value);
        }
        else if (name == 'subCategory') {
            setSubCategory(value);
        }
        else if (name == 'country') {
            setCountry(value);
        }
        else if (name == 'state') {
            setState(value);
        }
        else {
            console.log("nothing");
        }
    }

    //get masterdata
    const getMasterDataType = () => {
        axios.get(
           `http://localhost:8080/api/jsonws/masterdata.masterdata/get-type-masterdata?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setTypeMData(res.data);
            })

    }

    const getMasterDataDeliveryMode = () => {
        axios.get(
           `http://localhost:8080/api/jsonws/masterdata.masterdata/get-delivery-mode-masterdata?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setDeliveryModeMData(res.data);
            })
    }
    const getMasterDataOrganization = () => {
        axios.get(
           ` http://localhost:8080/api/jsonws/masterdata.masterdata/get-organization-masterdata?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setOrganizationMData(res.data);
            })
    }
    const getMasterDataSubOrganization = () => {
        axios.get(
           ` http://localhost:8080/api/jsonws/masterdata.masterdata/get-sub-organization-masterdata/organization-id/${organization}/?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setsubOrganizationMData(res.data);
            })

    }
    const getMasterDataCategory = () => {
        axios.get(
           ` http://localhost:8080/api/jsonws/masterdata.masterdata/get-receipt-category-masterdata?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setCategoryMData(res.data);
            })
    }
    const getMasterDataSubCategory = () => {
        axios.get(
           ` http://localhost:8080/api/jsonws/masterdata.masterdata/get-receipt-sub-category-masterdata/receipt-category-id/${category}/?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setSubCategoryMData(res.data);
            })
    }
    const getMasterDataCountry = () => {
        axios.get(
           `http://localhost:8080/api/jsonws/masterdata.masterdata/get-country-masterdata/?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setConutryMData(res.data);
            })
    }
    const getMasterDataState = () => {
        axios.get(
          //  ` http://localhost:8080/api/jsonws/masterdata.masterdata/get-state-masterdata/country-id/${country}/?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setStateMData(res.data);
            })

    }

    //use effect for first load
    useEffect(() => {
        getMasterDataType();
        getMasterDataDeliveryMode();
        getMasterDataCategory();
        getMasterDataSubCategory();
        getMasterDataOrganization();
        getMasterDataSubOrganization();
        getMasterDataCountry();
        getMasterDataState();
       
    }, [])

    //use effect for after choose the select value
    useEffect(() => {
        getMasterDataSubOrganization();
        getMasterDataSubCategory();
        getMasterDataState();
    }, [organization, category, country])




    //submit function
    const handleSubmit = () => {

        // navigate("/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_tgul/receipt-view");

        console.log("fields ----   " + date + type + deliveryMode +
            receivedOn + letterDate + referenceNumber + modeNumber + organization + subOrganization +
            name + designation + mobile + email + address +
            country + state + city + pinCode + category + subCategory +
            subject + remarks);

    }
    return (
        <div className="receipt">
            
            <form >
                <div className="row">
                    <div className="col-6 border">
                        <label>
                            <FaUpload style={{ fontSize: '23px', padding: "4px", borderRadius: "3px", color: "white", backgroundColor: "blue" }} />
                            <input type="file" id='document' name="document" onChange={handleSubmission} />
                        </label>
                        <div className="pdf-container">
                       {viewTempFileUrl? <embed src={`${viewTempFileUrl}`}  type="application/pdf" width="400" height="400" />: <span width="400" height="400" style={{border:'1px solid black'}} ></span>}
                             
                        </div>
                    </div>
                    <div className="col-6 border ">
                        <div className='scroll'>
                            <div className="border mt-1 p-1">
                                <div className="border" style={{ backgroundColor: "gainsboro" }}>
                                    <h4>
                                        <FaFileContract />
                                        Diary Details</h4>
                                </div>
                                <div className="row">
                                    <div className="col-md-4 mt-3">
                                        <div className="textOnInput">
                                            <label>Created on</label>
                                            <input className="form-control" type="text" value={date} disabled />
                                        </div>
                                    </div>
                                    <div className="col-md-4 mt-3">
                                        <div className="textOnInput">
                                            <label>Type</label>
                                            <select className="form-select" name='type' onChange={getMasterDataValue} >
                                                {typeMData.map((typeData, i) => {
                                                    return (
                                                        <option key={i} value={typeData.masterdataId} defaultValue={typeData.masterdataId}>
                                                            {typeData.value}
                                                        </option>
                                                    )
                                                })}
                                            </select>
                                        </div>
                                    </div>
                                    <div className="col-md-4 mt-3">
                                        <div className="textOnInput">
                                            <label >Delivery Mode</label>
                                            <select className="form-select" name='deliveryMode' onChange={getMasterDataValue}  >
                                                {deliveryModeMData.map((deliveryModeData, i) => {
                                                    return (
                                                        <option key={i} value={deliveryModeData.masterdataId}>
                                                            {deliveryModeData.value}
                                                        </option>
                                                    )
                                                })}
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div className="row ">
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label >Received on</label>
                                            <input className="form-control" type="date" name='receivedOn' onChange={(e) => { setReceivedOn(e.target.value) }} />
                                        </div>
                                    </div>
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Letter Date</label>
                                            <input className="form-control" type="date" name='letterDate' onChange={(e) => { setLetterDate(e.target.value) }} />
                                        </div>
                                    </div>
                                </div>
                                <div className="row ">
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Reference Number</label>
                                            <input className="form-control" type="text" name='referenceNumber' onChange={(e) => { setReferenceNumber(e.target.value) }} />
                                        </div>
                                    </div>

                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Mode Number</label>
                                            <input className="form-control" type="text" name='modeNumber' onChange={(e) => { setModeNumber(e.target.value) }} />
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="border mt-1 p-1">
                                <div className="border " style={{ backgroundColor: "gainsboro" }}>
                                    <h4>
                                        <FaEnvelope />
                                        Sender Details</h4>
                                </div>
                                <div className="row">
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Organization</label>
                                            <select className="form-select" name='organization' onChange={getMasterDataValue}  >
                                                {organizationMData.map((organizationData, i) => {
                                                    return (
                                                        <option key={i} value={organizationData.masterdataId}>
                                                            {organizationData.value}
                                                        </option>
                                                    )
                                                })}
                                            </select>
                                        </div>
                                    </div>
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Sub Organization</label>
                                            <select className="form-select" name='subOrganization' onChange={getMasterDataValue}  >
                                                {subOrganizationMData.map((subOrganizationData, i) => {
                                                    return (
                                                        <option key={i} value={subOrganizationData.masterdataId}>
                                                            {subOrganizationData.value}
                                                        </option>
                                                    )
                                                })}
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div className="row ">
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Name</label>
                                            <input className="form-control" type="text" name='name' onChange={(e) => { setName(e.target.value) }} />
                                        </div>
                                    </div>
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Designation</label>
                                            <input className="form-control" type="text" name='designation' onChange={(e) => { setDesignation(e.target.value) }} />
                                        </div>
                                    </div>
                                </div>
                                <div className="row ">
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Mobile</label>
                                            <input className="form-control" type="text" name='mobile' onChange={(e) => { setMobile(e.target.value) }} />
                                        </div>
                                    </div>
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Email</label>
                                            <input className="form-control" type="text" name='email' onChange={(e) => { setEmail(e.target.value) }} />
                                        </div>
                                    </div>
                                </div>
                                <div className="col mt-3">
                                    <div className="textOnInput fullTextFields">
                                        <label >Address</label>
                                        <textarea className="form-control" name='address' onChange={(e) => { setAddress(e.target.value) }} />
                                    </div>
                                </div>
                                <div className="row ">
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Country</label>
                                            <select className="form-select" name='country' onChange={getMasterDataValue}  >
                                                {countryMData.map((setCountryData, i) => {
                                                    return (
                                                        <option key={i} value={setCountryData.masterdataId}>
                                                            {setCountryData.value}
                                                        </option>
                                                    )
                                                })}
                                            </select>
                                        </div>
                                    </div>
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>State</label>
                                            <select className="form-select" name='state' onChange={getMasterDataValue}  >
                                                {stateMData.map((setStateData, i) => {
                                                    return (
                                                        <option key={i} value={setStateData.masterdataId}>
                                                            {setStateData.value}
                                                        </option>
                                                    )
                                                })}
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div className="row ">
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>City/District</label>
                                            <input className="form-control" type="text" name='city' onChange={(e) => { setCity(e.target.value) }} />
                                        </div>
                                    </div>
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Pin Code</label>
                                            <input className="form-control" type="text" name='pinCode' onChange={(e) => { setPinCode(e.target.value) }} />
                                        </div>
                                    </div>
                                </div>


                                <div className="border mt-1 p-1">
                                    <div className="border" style={{ backgroundColor: "gainsboro" }}>
                                        <h4>
                                            <FaFileAlt />
                                            Receipt Details</h4>
                                    </div>
                                    <div className="row ">
                                        <div className="col-md-6 mt-3">
                                            <div className="textOnInput">
                                                <label>Category</label>
                                                <select className="form-select" name='category' onChange={getMasterDataValue}  >
                                                    {categoryMData.map((categoryData, i) => {
                                                        return (
                                                            <option key={i} value={categoryData.masterdataId}>
                                                                {categoryData.value}
                                                            </option>
                                                        )
                                                    })}
                                                </select>
                                            </div>
                                        </div>
                                        <div className="col-md-6 mt-3">
                                            <div className="textOnInput">
                                                <label>Sub Category</label>
                                                <select className="form-select" name='subCategory' onChange={getMasterDataValue} >
                                                    {subCategoryMData.map((subCategoryData, i) => {
                                                        return (
                                                            <option key={i} value={subCategoryData.masterdataId}>
                                                                {subCategoryData.value}
                                                            </option>
                                                        )
                                                    })}
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div className="col mt-3">
                                        <div className="textOnInput fullTextFields">
                                            <label>Subject</label>
                                            <textarea className="form-control" name='subject' onChange={(e) => { setSubject(e.target.value) }} />
                                        </div>
                                    </div>
                                    <div className="col mt-3">
                                        <div className="textOnInput fullTextFields">
                                            <label>Remarks</label>
                                            <input className="form-control" type="text" name='remarks' onChange={(e) => { setRemarks(e.target.value) }} />
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div >
                            <button type='button' className='btn btn-primary' style={{ margin: 'auto 40%' }} onClick={handleSubmit}>Generate</button>
                        </div>
                    </div>
                </div >
            </form >
        </div>
    );
}
export default CreateReceipt;	