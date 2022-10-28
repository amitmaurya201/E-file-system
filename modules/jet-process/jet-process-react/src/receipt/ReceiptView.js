import React from "react";
import { useNavigate } from "react-router-dom";

const ReceiptView = () => {
    const navigate=useNavigate();

    const handleClick=()=>{
       // alert('h');
        navigate("/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_cvqk/create-receipt");
    }
    // import { useHistory } from "react-router-dom";

    // const ReceiptView = () => {
    //     const history=useHistory();
    
    //     const handleClick=()=>{
    //        // alert('h');
    //        history.push("/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_cvqk/create-receipt");
    //     }
    return (
        <>
            <div>
                <h2>ReceiptView</h2>
                <button onClick={handleClick}>Add</button>
                <button>Edit</button>
            </div>
        </>
    );
}
export default ReceiptView;