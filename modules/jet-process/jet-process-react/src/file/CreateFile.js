import React, { Fragment, useEffect, useState } from "react";
import { useForm } from "react-hook-form";
import swal from "sweetalert";
import Axios from "axios";

const CreateFile = () => {

    // ------------------  VARIABLE -----------------

    const currentDate = new Date();
    const curretnYear = currentDate.getFullYear();
    let resposeFail = false;

    // --------------------- USE STATE ----------------

    const [nature, setNature] = useState(true);
    const [type, setType] = useState(true);
    const [category, setCategory] = useState([]);
    const [subCategory, setSubCategory] = useState([]);
    const [basicHeadData, setBasicHeadData] = useState([]);
    const [primaryHeadData, setPrimaryHeadData] = useState([]);
    const [secondaryHeadDat, setSecondaryHeadData] = useState([]);
    const [tertiaryHeadData, setTertiaryHeadData] = useState([]);
    const [fileCodeData, setFileCodeData] = useState([]);

    const { register, handleSubmit, errors, reset } = useForm();
    const [formValue, setFormValue] = useState({
        nature: "Electronic",
        type: "NON-SFS",
        basicHead: "",
        primaryHead: "",
        secondaryHead: "",
        tertiaryHead: "",
        year: "" + curretnYear + "",
        fileCode: "",
        fileNumber: "",
        subject: "",
        category: "",
        subCategory: "",
        remark: "",
        reference: ""
    });

    //  ----------------------- URL -----------------

    let basicHeadUrl = `http://localhost:8080/api/jsonws/masterdata.masterdata/get-basic-head-masterdata?p_auth=` + Liferay.authToken;
    let primaryHeadUrl = `http://localhost:8080/api/jsonws/masterdata.masterdata/get-primary-head-masterdata/basic-head-id`;
    let secondaryHeadUrl = `http://localhost:8080/api/jsonws/masterdata.masterdata/get-secondary-head-masterdata/primary-head-id`;
    let tertiaryHeadUrl = `http://localhost:8080/api/jsonws/masterdata.masterdata/get-teritary-head-masterdata/secondary-head-id`;
    let fileCodeUrl = `http://localhost:8080/api/jsonws/masterdata.masterdata/get-file-code-masterdata?p_auth=` + Liferay.authToken;
    let categoryUrl = `http://localhost:8080/api/jsonws/masterdata.masterdata/get-category-masterdata?p_auth=` + Liferay.authToken;
    let subCategoryUrl = `http://localhost:8080/api/jsonws/masterdata.masterdata/get-sub-category-masterdata/category-id`;



    // ------------------------- METHOS -----------------------



    const onchange = (e) => {
        setFormValue({ ...formValue, [e.target.name]: e.target.value })
        console.log("Hello......" + formValue);
        if (e.target.name == "basicHead") {
            getPrimaryHead(e.target.value);
        }
        if (e.target.name == "primaryHead") {
            getSecondaryHead(e.target.value);
        }
        if (e.target.name == "secondaryHead") {
            getTertiaryHead(e.target.value);
        }
        if (e.target.name == "category") {
            getSubCategory(e.target.value);
        }


    }

    const onType = (e) => {

        if (e.target.value === 'SFS') {
            setType(false)
        } else {
            setType(true)
        }
    }
    const onSubmitHandle = (event) => {
        console.log("on form Submit Handle ......." + formValue.type + " : Nature :- " + formValue.nature);
        Axios.post(`http://localhost:8080/api/jsonws/jet_process.docfile/add-doc-file/group-id/${Liferay.ThemeDisplay.getScopeGroupId()}/nature/${formValue.nature}/type/${formValue.type}/subject/${formValue.subject}/category/${formValue.category}/sub-category/${formValue.subCategory}/remarks/${formValue.remark}/reference/${formValue.reference}?p_auth=${Liferay.authToken}`)
            .then((response) => {
                console.log("response.data.message", response.data)
                swal(
                    {
                        title: "successfull !",
                        text: `You Have successfully created Your File! And Your File Number is ${response.data.fileNumber} `,
                        icon: "success",
                        button: "ok"
                    }
                )
            }).catch(error => {
                resposeFail = true;
                onFail();
                console.log(error)
            })
        reset();

    }
    useEffect(() => {
        Axios.get(categoryUrl).then((response) => {
            if (response) {
                let array = []
                response.data.map((data) => {
                    console.log("Category : " + data.value + " : " + "Category : " + data.masterdataId + " : : " + data.code);
                    array.push(data)
                })
                setCategory(array);
            }
        }).catch(error => {
            resposeFail = true;
            onFail();
            console.log(error)
        }
        );
        Axios.get(basicHeadUrl).then((response) => {
            if (response) {
                let array = []
                response.data.map((data) => {
                    console.log("basic head:- " + data.code + " : : " + data.value);
                    array.push(data)
                })
                setBasicHeadData(array);
            }
        }).catch(error => {
            resposeFail = true;
            onFail();
            console.log(error)
        }
        );
        Axios.get(fileCodeUrl).then((response) => {
            if (response) {

                let array = []
                response.data.map((data) => {
                    console.log("File code :- " + response.data);
                    array.push(data)
                })
                setFileCodeData(array);
            }
        }).catch(error => {
            resposeFail = true;
            onFail();
            console.log("Hello......" + error)
        }
        );
    }, []);

    const getPrimaryHead = (basicHeadId) => {
        Axios.get(`${primaryHeadUrl}/${basicHeadId}?p_auth=` + Liferay.authToken).then((response) => {
            console.log("primary head :- " + basicHeadId);
            if (response) {
                let array = []
                response.data.map((data) => {
                    // console.log("primary head :- " + response.data);
                    array.push(data)
                })
                setPrimaryHeadData(array);
            }
        }).catch(error => {
            resposeFail = true;
            onFail();
            console.log(error)
        }
        );
    }

    const getSecondaryHead = (primaryHeadId) => {
        Axios.get(`${secondaryHeadUrl}/${primaryHeadId}?p_auth=` + Liferay.authToken).then((response) => {
            if (response) {
                let array = []
                response.data.map((data) => {
                    console.log("Secondary :- " + response.data);
                    array.push(data)
                })
                setSecondaryHeadData(array)
            }

        }).catch(error => {
            resposeFail = true;
            onFail();
            console.log(error)
        }
        );
    }

    const getTertiaryHead = (secondaryHeadId) => {
        Axios.get(`${tertiaryHeadUrl}/${secondaryHeadId}?p_auth=` + Liferay.authToken).then((response) => {
            if (response) {
                let array = []
                response.data.map((data) => {
                    console.log("Tertieary head :- " + response.data);
                    array.push(data)
                })
                setTertiaryHeadData(array);
            }
        }).catch(error => {
            resposeFail = true;
            onFail();

            console.log(error)
        }
        );
    }

    const getSubCategory = (categoryId) => {
        console.log("category id" + categoryId);
        Axios.get(`${subCategoryUrl}/${categoryId}?p_auth=` + Liferay.authToken).then((response) => {
            if (response) {
                let array = []
                response.data.map((data) => {
                    console.log("Sub Category:- " + response.data);
                    array.push(data)
                })
                setSubCategory(array);
            }

        }).catch(error => {

            resposeFail = true;
            onFail();
            console.log(error)
        }
        );
    }
    // ---------------------  Request Fail Message ----------------- 

    const onFail = () => {
        if (resposeFail) {
            console.log("Something went wrong ! We are Unable to load data..")
            swal(
                {
                    title: "Opps Something Went Wrong !",
                    text: "We Are Unable to load data !",
                    icon: "error",
                    button: "ok",
                }
            )
            resposeFail = false;
        }
    }

    return (
        <Fragment>
            <div className="container m-3">
                <div className="card">
                    <form onSubmit={handleSubmit(onSubmitHandle)}>
                        <div className="card-body">
                            <div className="row">
                                <div className="col-md-12 col-sm-12" >
                                    <div className="card mt-3">
                                        <div className="card-body">
                                            <div className="row mt-2">
                                                <div className="col-md-12 col-sm-12">
                                                    <div className="text-center">
                                                        <h1>भारत सरकार</h1>
                                                        <h4>GOVERNMENT OF INDIA</h4>
                                                        <h4>Ministry of Home Affairs ( MHA )</h4>
                                                    </div>
                                                    <div className="container">
                                                        <div className="row">
                                                            <div className="col-md-12 d-flex justify-content-between">
                                                                <div className="row">
                                                                    <div className="col-auto"> <label><b>Nature</b></label></div>
                                                                    <div className="col-auto">
                                                                        <select className="form-select form-control" id="nature" name="nature" onChange={onchange}>
                                                                            <option value="Electronic" >Electronic</option>
                                                                            <option value="Physical">Physical</option>
                                                                        </select>
                                                                    </div>
                                                                </div>
                                                                <div className="row">
                                                                    <div className="col-auto">
                                                                        <label><b>Type</b></label>
                                                                    </div>
                                                                    <div className="col-auto">
                                                                        <select className="form-select form-control" id="type" name="type" onChange={onType}>
                                                                            <option value="NON-SFS">NON SFS</option>
                                                                            <option value="SFS">SFS</option>
                                                                        </select>
                                                                    </div>
                                                                </div>

                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div className="container">
                                                        <div className="row">

                                                            <div className="col-md-12">
                                                                {
                                                                    type ? (
                                                                        <div className="row mt-3 ">
                                                                            <fieldset className="col-md-12 p-0 child-scheduler-border">
                                                                                <legend className="child-scheduler-border">File No.</legend>
                                                                                <div className="row">
                                                                                    <div className="col-md-2 col-sm-6 mt-2"  >
                                                                                        <select className="form-select form-control" id="basicHead" name="basicHead"
                                                                                            onChange={onchange} ref={register({ required: { value: true, message: 'basic Head is required' } })} >
                                                                                            <option value=''>BASIC Head</option>
                                                                                            {
                                                                                                basicHeadData.map((data, i) => (
                                                                                                    <Fragment key={i}>
                                                                                                        <option value={data.masterdataId}> {data.code} - {data.value}</option>
                                                                                                    </Fragment>
                                                                                                ))
                                                                                            }
                                                                                        </select>
                                                                                        {errors.basicHead && <small className="errors">{errors.basicHead.message}</small>}
                                                                                    </div>
                                                                                    <div className="col-md-2 col-sm-6 mt-2" >
                                                                                        <select className="form-select form-control" id="primaryHead" name="primaryHead"
                                                                                            onChange={onchange} ref={register({ required: { value: true, message: 'Primary Head is required' } })} >
                                                                                            <option value=''>Primary Head Code</option>
                                                                                            {
                                                                                                primaryHeadData.map((data, i) => (
                                                                                                    <Fragment key={i}>
                                                                                                        <option value={data.masterdataId}>{data.code} - {data.value}</option>
                                                                                                    </Fragment>
                                                                                                ))
                                                                                            }

                                                                                        </select>
                                                                                        {errors.primaryHead && <small className="errors">{errors.primaryHead.message}</small>}
                                                                                    </div>
                                                                                    <div className="col-md-2 col-sm-6 mt-2">
                                                                                        <select className="form-select form-control" id="secondaryHead" name="secondaryHead"
                                                                                            onChange={onchange} ref={register({ required: { value: true, message: 'Secondary Head is required' } })} >
                                                                                            <option value=''>Secondary Head Code</option>
                                                                                            {
                                                                                                secondaryHeadDat.map((data, i) => (
                                                                                                    <Fragment key={i}>
                                                                                                        <option value={data.masterdataId}>{data.code} - {data.value}</option>
                                                                                                    </Fragment>
                                                                                                ))
                                                                                            }
                                                                                        </select>
                                                                                        {errors.secondaryHead && <small className="errors">{errors.secondaryHead.message}</small>}
                                                                                    </div>
                                                                                    <div className="col-md-2 col-sm-6 mt-2"  >
                                                                                        <select className="form-select form-control" id="tertiaryHead" name="tertiaryHead"
                                                                                            onChange={onchange} ref={register({ required: { value: true, message: 'Tertiary Head is required' } })} >
                                                                                            <option value=''>Tertiary Head Code</option>
                                                                                            {
                                                                                                tertiaryHeadData.map((data, i) => (
                                                                                                    <Fragment key={i}>
                                                                                                        <option value={data.masterdataId}>{data.value}</option>
                                                                                                    </Fragment>
                                                                                                ))
                                                                                            }
                                                                                        </select>
                                                                                        {errors.tertiaryHead && <small className="errors">{errors.tertiaryHead.message}</small>}
                                                                                    </div>
                                                                                    <div className="col-md-2 col-sm-6 mt-2">
                                                                                        <input type="text" className="form-control" id="year" name="year" readOnly value={curretnYear}
                                                                                            onChange={onchange} ref={register({ required: { value: true, message: 'Year is required' } })} ></input>
                                                                                    </div>
                                                                                    <div className="col-md-2 col-sm-6 mt-2">
                                                                                        <select className="form-select form-control" id="fileCode" name="fileCode"
                                                                                            onChange={onchange} ref={register({ required: { value: true, message: 'File code is required' } })} >
                                                                                            <option value="">File-Code </option>
                                                                                            {
                                                                                                fileCodeData.map((data, i) => (
                                                                                                    <Fragment key={i}>
                                                                                                        <option value={data.masterdataId}>{data.code} - {data.value}</option>
                                                                                                    </Fragment>
                                                                                                ))
                                                                                            }
                                                                                        </select>
                                                                                        {errors.fileCode && <small className="errors">{errors.fileCode.message}</small>}
                                                                                    </div>
                                                                                </div>

                                                                            </fieldset>
                                                                        </div>
                                                                    ) : (
                                                                        <div className="row">
                                                                            <fieldset className="col-md-12 child-scheduler-border">
                                                                                <legend className="child-scheduler-border">File No.</legend>
                                                                                <input className="form-control" type="text" name="fileNumber" id="fileNumber" onChange={onchange} ref={register({ required: { value: true, message: 'File number is required' } })} />
                                                                                {errors.fileNumber && <span className="errors">{errors.fileNumber.message}</span>}
                                                                            </fieldset>
                                                                        </div>
                                                                    )
                                                                }
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div className="row">
                                <div className="container">
                                    <fieldset className="scheduler-border col-md-12">
                                        <div className="row">
                                            <fieldset className="col-md-12 child-scheduler-border">
                                                <legend className="child-scheduler-border">Subject</legend>
                                                <input className="form-control" type="text" name="subject" id="subject"
                                                    onChange={onchange} ref={register({
                                                        required: "Subject is required", pattern: {
                                                            value: /^[a-zA-Z\s]*$/,
                                                            message: "Only letter is allow"
                                                        }
                                                    })} />
                                                {errors.subject && <span className="errors">{errors.subject.message} </span>}
                                            </fieldset>
                                        </div>
                                        <div className="row">
                                            <fieldset className="child-scheduler-border col-md-6">
                                                <legend className="child-scheduler-border">Category</legend>
                                                <div className="input-group">
                                                    <select className="form-select form-control" id="category" name="category"
                                                        onChange={onchange} ref={register({ required: 'category is required' })} >
                                                        <option value='' >Choose...</option>
                                                        {
                                                            category.map((data, i) => (
                                                                <Fragment key={i}>
                                                                    <option value={data.masterdataId}>{data.value}</option>
                                                                </Fragment>
                                                            ))
                                                        }
                                                    </select>
                                                </div>
                                                {errors.category && <span className="errors">{errors.category.message}</span>}
                                            </fieldset>
                                            <fieldset className="child-scheduler-border col-md-6">
                                                <legend className="child-scheduler-border">Sub Category</legend>
                                                <div className="input-group">
                                                    <select className="form-select form-control" id="subCategory" name="subCategory" onChange={onchange} ref={register({ required: true })} >
                                                        <option value='' >Choose...</option>
                                                        {
                                                            subCategory.map((data, i) => (
                                                                <Fragment key={i}>
                                                                    <option value={data.id}>{data.value}</option>
                                                                </Fragment>
                                                            ))
                                                        }
                                                    </select>
                                                </div>
                                                {errors.subCategory && <span className="errors">Sub-Category is required</span>}
                                            </fieldset>
                                        </div>
                                    </fieldset>
                                </div>
                                <div className="container">
                                    <fieldset className="scheduler-border col-md-12">
                                        <div className="row">
                                            <fieldset className="col-md-12 child-scheduler-border">
                                                <legend className="child-scheduler-border">Remark</legend>
                                                <textarea className="form-control col-md-12" rows="3" type="text" name="remark"
                                                    id="remark" onChange={onchange}
                                                    ref={register({ required: "Remark is required", maxLength: { value: 1000, message: "Remark cann't be more than 1000 letter" } })} ></textarea>
                                                {errors.remark && <span className="errors">{errors.remark.message}</span>}
                                            </fieldset>
                                        </div>
                                        <div className="row">
                                            <fieldset className="child-scheduler-border col-md-12">
                                                <legend className="child-scheduler-border" >Reference</legend>
                                                <input className="form-control col-md-12 " type="text" name="reference"
                                                    id="reference" onChange={onchange} ref={register({ required: 'Reference is Required', maxLength: { value: 250, message: "Reference cann't be more than 250 letter" } })} />
                                                {errors.reference && <span className="errors">{errors.reference.message}</span>}
                                            </fieldset>
                                        </div>
                                    </fieldset>
                                </div>
                            </div>
                            <div className="text-center">
                                <button type="submit" className="btn btn-danger ">Create File</button>
                            </div>
                        </div>
                    </form>
                </div >
            </div >
        </Fragment >
    );
}
export default CreateFile;