import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { FaFileContract, FaEnvelope, FaUpload, FaWindowClose, FaFileAlt } from 'react-icons/fa';
import { useForm } from 'react-hook-form';
import { useNavigate } from 'react-router-dom';

const CreateReceipt = ({data}) => {
   
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
    const [organization, setOrganization] = useState('0');
    const [subOrganization, setSubOrganization] = useState("");
    const [name, setName] = useState("");
    const [designation, setDesignation] = useState("");
    const [mobile, setMobile] = useState("");
    const [email, setEmail] = useState("");
    const [address, setAddress] = useState("");
    const [country, setCountry] = useState('0');
    const [state, setState] = useState("");
    const [city, setCity] = useState("");
    const [pinCode, setPinCode] = useState("");

    //for all sender fields
    const [category, setCategory] = useState('0');
    const [subCategory, setSubCategory] = useState("");
    const [subject, setSubject] = useState("");
    const [remarks, setRemarks] = useState("");

    //for file fields
    const [document, setdocument] = useState();
    const [pdfFile, setPdfFile] = useState();
    const [fileData, setFileData] = useState();

    //for redirect the page
    const navigate=useNavigate();

    //-----------hook validation--------------
    const { register, handleSubmit, errors } = useForm();


    //for handling file change
    const groupId = Liferay.ThemeDisplay.getScopeGroupId();
    const onFileSelect = async (event) => {
        setFileData(event.target.files[0]);
        const file = event.target.files[0];
        if (file) {
            var filereader = new FileReader();
            filereader.readAsDataURL(file);
            filereader.onload = (evt) => {
                var base64 = evt.target.result;
                setPdfFile(base64);
                return base64
            }
        }
    };

    const handleSubmission = (e) => {
        console.log(fileData);
        e.preventDefault();
        const formData = new FormData();
        formData.append('document', fileData);
        formData.append('groupId', groupId);
        axios.post(`http://localhost:8080/o/jet-process-docs/v1.0/uploadFile?p_auth=` + Liferay.authToken, formData, {
            headers: { "Content-Type": "application/json" }
        })
            .then((result) => {
                console.log('Success:', result.data);
                setdocument(result.data.description);
            }).catch((error) => {
                console.log("error happened");
                console.error('Error:', error);
            });
    };
    //------------- Master Data fields--------------
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
            console.log("no data");
        }
    }

    //--------------------get masterdata-----------------------
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
              `http://localhost:8080/api/jsonws/masterdata.masterdata/get-organization-masterdata?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setOrganizationMData(res.data);
            })
    }
    const getMasterDataSubOrganization = () => {
        axios.get(
             `http://localhost:8080/api/jsonws/masterdata.masterdata/get-sub-organization-masterdata/organization-id/${organization}/?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setsubOrganizationMData(res.data);
            })

    }
    const getMasterDataCategory = () => {
        axios.get(
             `http://localhost:8080/api/jsonws/masterdata.masterdata/get-receipt-category-masterdata?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setCategoryMData(res.data);
            })
    }
    const getMasterDataSubCategory = () => {
        axios.get(
              `http://localhost:8080/api/jsonws/masterdata.masterdata/get-receipt-sub-category-masterdata/receipt-category-id/${category}/?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setSubCategoryMData(res.data);
            })
    }
    const getMasterDataCountry = () => {
        axios.get(
            `http://localhost:8080/api/jsonws/masterdata.masterdata/get-countries-masterdata/?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setConutryMData(res.data);
            })
    }
    const getMasterDataState = () => {
        axios.get(
              `http://localhost:8080/api/jsonws/masterdata.masterdata/get-states-masterdata/country-id/${country}/?p_auth=` + Liferay.authToken
        )
            .then((res) => {
                setStateMData(res.data);
            })

    }

    //---------------------use effect for first load of get masterdata ----------------------
    useEffect(() => {
        getId();

        //getReceipt();

        getMasterDataType();
        getMasterDataDeliveryMode();
        getMasterDataCategory();
        getMasterDataSubCategory();
        getMasterDataOrganization();
        getMasterDataSubOrganization();
        getMasterDataCountry();
        getMasterDataState();
        //groupId();
    }, [])

    //-------------use effect for after choose the select value of masterdata-------------------------------
    useEffect(() => {
        getMasterDataSubOrganization();
        getMasterDataSubCategory();
        getMasterDataState();
    }, [organization, category, country])

    //submit function   
    const onSubmit = (e) => {

        navigate("/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_ssvp/view-receipt");

        console.log("fields ----   " + date + type + deliveryMode +
            receivedOn + letterDate + referenceNumber + modeNumber + organization + subOrganization +
            name + designation + mobile + email + address +
            country + state + city + pinCode + category + subCategory +
            subject + remarks );

        try {
            axios.post(`http://localhost:8080/api/jsonws/jet_process.receipt/create-receipt/group-id/${Liferay.ThemeDisplay.getScopeGroupId()}/type-id/${type}/delivery-mode-id/${deliveryMode}/received-on/${receivedOn}/letter-date/${letterDate}/reference-number/${referenceNumber}/mode-number/${modeNumber}/receipt-category-id/${category}/receipt-sub-category-id/${subCategory}/subject/${subject}/remarks/${remarks}/document/${document}/name/${name}/designation/${designation}/mobile/${mobile}/email/${email}/address/${address}/country-id/${country}/state-id/${state}/pin-code/${pinCode}/organization-id/${organization}/sub-organization-id/${subOrganization}/city/${city}/?p_auth=` + Liferay.authToken)
                .then((res) => {
                    console.log("res" + res.data);
                })
        } catch (error) {
            console.error(error.response.data)
        }

    }


    return (
        <div className="receipt">
            <form onSubmit={handleSubmit(onSubmit)}>
                <div className="row">
                    <div className="col-6 border">
                        <label>
                            <FaUpload style={{ fontSize: '23px', padding: "4px", borderRadius: "3px", color: "white", backgroundColor: "blue" }} />
                            <input type="file" id='document' name="document" hidden accept=".pdf" onChange={onFileSelect} />
                        </label>
                        {/* <FaWindowClose style={{ fontSize: '26px', marginLeft: "10px", color: "blue" }}  /> */}
                        <div className="pdf-container">
                            <br />
                            {/* Show pdf conditionally (if we have one) */}
                            {pdfFile ? <embed src={`${pdfFile}`} style={{ alignContent: 'center' }} width="400" height="400" /> : <span width="400" height="400" style={{ border: '1px solid black' }} ></span>}

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
                                            <label>Type<span className='text-danger'>*</span></label>
                                            <select className="form-select" name='type' onChange={getMasterDataValue}
                                                ref={register({
                                                    required: "Type is required",
                                                })}>
                                                <option value="">Type</option>
                                                {typeMData.map((typeData, i) => {
                                                    return (
                                                        <option key={i} value={typeData.masterdataId} defaultValue={typeData.masterdataId}>{typeData.value}</option>
                                                    )
                                                })}
                                            </select>
                                            {errors.type && (
                                                <small className="errors">{errors.type.message}</small>
                                            )}
                                        </div>
                                    </div>
                                    <div className="col-md-4 mt-3">
                                        <div className="textOnInput">
                                            <label >Delivery Mode<span className='text-danger'>*</span></label>
                                            <select className="form-select" name='deliveryMode' onChange={getMasterDataValue}
                                                ref={register({
                                                    required: "Delivery Mode is required",
                                                })}>
                                                <option value="">Delivery Mode</option>
                                                {deliveryModeMData.map((deliveryModeData, i) => {
                                                    return (
                                                        <option key={i} value={deliveryModeData.masterdataId}> {deliveryModeData.value}</option>
                                                    )
                                                })}
                                            </select>
                                            {errors.deliveryMode && (
                                                <small className="errors">{errors.deliveryMode.message}</small>
                                            )}
                                        </div>
                                    </div>
                                </div>
                                <div className="row ">
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label >Received on<span className='text-danger'>*</span></label>
                                            <input className="form-control" type="date" name='receivedOn' onChange={(e) => { setReceivedOn(e.target.value) }}
                                                ref={register({
                                                    required: "This field is required",
                                                })}
                                            />
                                            {errors.receivedOn && (
                                                <small className="errors">{errors.receivedOn.message}</small>
                                            )}
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
                                            <input className="form-control" type="text" name='referenceNumber' onChange={(e) => { setReferenceNumber(e.target.value) }}
                                                ref={register({
                                                    maxLength: {
                                                        value: 250,
                                                        message: "please enter value less than 250 characters"
                                                    }
                                                })}
                                            />
                                            {errors.referenceNumber && (
                                                <small className="errors">{errors.referenceNumber.message}</small>
                                            )}
                                        </div>
                                    </div>

                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Mode Number</label>
                                            <input className="form-control" type="text" name='modeNumber' onChange={(e) => { setModeNumber(e.target.value) }}
                                                ref={register({
                                                    maxLength: {
                                                        value: 250,
                                                        message: "please enter value less than 250 characters"
                                                    }
                                                })}
                                            />
                                            {errors.modeNumber && (
                                                <small className="errors">{errors.modeNumber.message}</small>
                                            )}
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
                                            <label>Organization<span className='text-danger'>*</span></label>
                                            <select className="form-select" name='organization' onChange={getMasterDataValue}
                                                ref={register({
                                                    required: "Organization is required",
                                                })}>
                                                <option value="">Organization</option>
                                                {organizationMData.map((organizationData, i) => {
                                                    return (
                                                        <option key={i} value={organizationData.masterdataId}>{organizationData.value}</option>
                                                    )
                                                })}
                                            </select>
                                            {errors.organization && (
                                                <small className="errors">{errors.organization.message}</small>
                                            )}
                                        </div>
                                    </div>
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Sub Organization</label>
                                            <select className="form-select" name='subOrganization' onChange={getMasterDataValue}  >
                                                <option value="">SubOrganization</option>
                                                {subOrganizationMData.map((subOrganizationData, i) => {
                                                    return (
                                                        <option key={i} value={subOrganizationData.masterdataId}>{subOrganizationData.value}</option>
                                                    )
                                                })}
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div className="row ">
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Name<span className='text-danger'>*</span></label>
                                            <input className="form-control" type="text" name='name' onChange={(e) => { setName(e.target.value) }}
                                                ref={register({
                                                    required: "Name is required",
                                                    maxLength: {
                                                        value: 250,
                                                        message: "please enter value less than 250 characters"
                                                    }
                                                })}
                                            />
                                            {errors.name && (
                                                <small className="errors">{errors.name.message}</small>
                                            )}
                                        </div>
                                    </div>
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Designation<span className='text-danger'>*</span></label>
                                            <input className="form-control" type="text" name='designation' onChange={(e) => { setDesignation(e.target.value) }}
                                                ref={register({
                                                    required: "Designation is required",
                                                    maxLength: {
                                                        value: 250,
                                                        message: "please enter value less than 250 characters"
                                                    }
                                                })}
                                            />
                                            {errors.designation && (
                                                <small className="errors">{errors.designation.message}</small>
                                            )}
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="row ">
                                <div className="col-md-6 mt-3">
                                    <div className="textOnInput">
                                        <label>Mobile</label>
                                        <input className="form-control" type="text" name='mobile' onChange={(e) => { setMobile(e.target.value) }}
                                            ref={register({
                                                pattern: {
                                                    value: /^[0-9]{10}$/,
                                                    message: "Mobile should be maximum 10 numeric characters"
                                                }
                                            })}
                                        />
                                        {errors.mobile && (
                                            <small className="errors">{errors.mobile.message}</small>
                                        )}
                                    </div>
                                </div>
                                <div className="col-md-6 mt-3">
                                    <div className="textOnInput">
                                        <label>Email</label>
                                        <input className="form-control" type="text" value={email} name='email' onChange={(e) => { setEmail(e.target.value) }}
                                            ref={register({
                                                maxLength: {
                                                    value: 250,
                                                    message: "please enter value less than 250 characters"
                                                }
                                            })}
                                        />
                                        {errors.email && (
                                            <small className="errors">{errors.email.message}</small>
                                        )}
                                    </div>
                                </div>
                            </div>
                            <div className="col mt-3">
                                <div className="textOnInput fullTextFields">
                                    <label >Address</label>
                                    <textarea className="form-control" name='address' value={address} onChange={(e) => { setAddress(e.target.value) }}
                                        ref={register({
                                            required: "Address is required",
                                            maxLength: {
                                                value: 1000,
                                                message: "please enter value less than 1000 characters"
                                            }
                                        })}
                                    />
                                    {errors.address && (
                                        <small className="errors">{errors.address.message}</small>
                                    )}
                                </div>
                            </div>
                            <div className="row ">
                                <div className="col-md-6 mt-3">
                                    <div className="textOnInput">
                                        <label>Country</label>
                                        <select className="form-select" name='country' onChange={getMasterDataValue}  >
                                            <option value="">Country</option>
                                            {
                                                countryMData.map((setCountryData, i) => {
                                                    return (
                                                        <option key={i} value={setCountryData.masterdataId}>{setCountryData.code}</option>
                                                    )
                                                })
                                            }
                                        </select>
                                    </div>
                                </div>
                                <div className="col-md-6 mt-3">
                                    <div className="textOnInput">
                                        <label>State</label>
                                        <select className="form-select" name='state' onChange={getMasterDataValue}  >
                                            <option value="">State</option>
                                            {stateMData.map((setStateData, i) => {
                                                return (
                                                    <option key={i} value={setStateData.masterdataId}>{setStateData.value}</option>
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
                                        <input className="form-control" type="text" name='city' onChange={(e) => { setCity(e.target.value) }}
                                            ref={register({
                                                maxLength: {
                                                    value: 250,
                                                    message: "please enter value less than 250 characters"
                                                }
                                            })}
                                        />
                                        {errors.city && (
                                            <small className="errors">{errors.city.message}</small>
                                        )}
                                    </div>
                                </div>
                                <div className="col-md-6 mt-3">
                                    <div className="textOnInput">
                                        <label>Pin Code</label>
                                        <input className="form-control" type="text" name='pinCode' onChange={(e) => { setPinCode(e.target.value) }}
                                            ref={register({
                                                maxLength: {
                                                    value: 8,
                                                    message: "PinCode should not be more than 8 characters"
                                                }
                                            })}
                                        />
                                        {errors.pinCode && (
                                            <small className="errors">{errors.pinCode.message}</small>
                                        )}
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
                                            <label>Category<span className='text-danger'>*</span></label>
                                            <select className="form-select" name='category' onChange={getMasterDataValue}
                                                ref={register({
                                                    required: "Category is required"
                                                })}>
                                                <option value="">Category</option>
                                                {categoryMData.map((categoryData, i) => {
                                                    return (
                                                        <option key={i} value={categoryData.masterdataId}>{categoryData.value}</option>
                                                    )
                                                })}
                                            </select>
                                            {errors.category && (
                                                <small className="errors">{errors.category.message}</small>
                                            )}
                                        </div>
                                    </div>
                                    <div className="col-md-6 mt-3">
                                        <div className="textOnInput">
                                            <label>Sub Category</label>
                                            <select className="form-select" name='subCategory' onChange={getMasterDataValue} >
                                                <option value="">SubCategory</option>
                                                {subCategoryMData.map((subCategoryData, i) => {
                                                    return (
                                                        <option key={i} value={subCategoryData.masterdataId}>{subCategoryData.value}</option>
                                                    )
                                                })}
                                            </select>
                                        </div>
                                    </div>
                                </div>
                                <div className="col mt-3">
                                    <div className="textOnInput fullTextFields">
                                        <label>Subject<span className='text-danger'>*</span></label>
                                        <textarea className="form-control" name='subject' onChange={(e) => { setSubject(e.target.value) }}
                                            ref={register({
                                                required: "Subject is required",
                                                maxLength: {
                                                    value: 1000,
                                                    message: "please enter value less than 1000 characters"
                                                }
                                            })}
                                        />
                                        {errors.subject && (
                                            <small className="errors">{errors.subject.message}</small>
                                        )}
                                    </div>
                                </div>
                                <div className="col mt-3">
                                    <div className="textOnInput fullTextFields">
                                        <label>Remarks</label>
                                        <input className="form-control" type="text" name='remarks' onChange={(e) => { setRemarks(e.target.value) }}
                                            ref={register({
                                                maxLength: {
                                                    value: 250,
                                                    message: "please enter value less than 250 characters"
                                                }
                                            })}
                                        />
                                        {errors.remarks && (
                                            <small className="errors">{errors.remarks.message}</small>
                                        )}
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div >
                            <button type='submit' onClick={handleSubmission} className='btn btn-primary' style={{ margin: 'auto 40%' }}>Generate</button>
                        </div>
                    </div>
                </div>
            </form >
        </div >
    );
}
export default CreateReceipt;	
