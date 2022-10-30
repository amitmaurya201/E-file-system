import React from 'react';
import CreateFile from './file/CreateFile';
import CreatedFileList from './file/CreatedFileList';
import Navbar from './receipt/Navbar';
import ReceiptView from './receipt/ReceiptView';
import CreateReceipt from './receipt/CreateReceipt';
import {BrowserRouter as Router,Routes,Route} from "react-router-dom";

function AppComponent() {
	
	
  return (
   <Router>
  <div className="App">	
  <Navbar/>
  <Routes>

    <Route exact path="/web/guest/file/-/jetprocessreact_INSTANCE_TvrAY0BwgfGP/create-file" element={<CreateFile />}></Route>
    <Route exact path="/web/guest/file/-/jetprocessreact_INSTANCE_TvrAY0BwgfGP/view-file" element={<CreatedFileList />}></Route>
    <Route exact path="/web/guest/file/-/jetprocessreact_INSTANCE_TvrAY0BwgfGP/create-receipt" element={<CreateReceipt />}></Route>
    <Route exact path="/web/guest/file/-/jetprocessreact_INSTANCE_TvrAY0BwgfGP/view-receipt" element={<ReceiptView />}></Route>
    </Routes>
  </div>
  </Router>
  );
}

export default AppComponent;