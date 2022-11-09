import React from 'react';
import CreateFile from './file/CreateFile';
import CreatedFileList from './file/CreatedFileList';
import Navbar from './receipt/Navbar';
import ReceiptView from './receipt/ReceiptView';
import CreateReceipt from './receipt/CreateReceipt';
import Home from './Home';
import { BrowserRouter as Router, Routes, Route } from "react-router-dom";

function AppComponent() {


  return (
    <Router>
      <div className="App">
        <Navbar />
        <Routes>
          <Route exact path="/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_mria/home" element={<Home />}></Route>

          <Route exact path="/web/guest/file/-/jetprocessreact_INSTANCE_TvrAY0BwgfGP/create-file" element={<CreateFile />}></Route>
          <Route exact path="/web/guest/file/-/jetprocessreact_INSTANCE_TvrAY0BwgfGP/view-file" element={<CreatedFileList />}></Route>
          <Route exact path="/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_mria/create-receipt/:receiptId" element={<CreateReceipt />}></Route>
          <Route exact path="/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_mria/view-receipt" element={<ReceiptView />}></Route>
        </Routes>
      </div>
    </Router>
  );
}

export default AppComponent;