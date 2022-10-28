import React from 'react';
import { Link } from 'react-router-dom';

const ReceiptNavbar = () => {
    return (
       <nav>
        <Link to="/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_tgul/receipt-view">Create Receipt</Link>
        <Link to="web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_tgul/create-receipt">ReceiptView</Link>
       </nav>
    );
}
export default ReceiptNavbar;