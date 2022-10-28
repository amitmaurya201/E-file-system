import React, { Fragment } from 'react';
import ReactDOM from 'react-dom';


/*  import 'react-toastify/dist/ReactToastify.css'; 
 // import Tostify from './Tostify';  */
 import CreateFile from './file/CreateFile'; 
 import CreatedFileList from './file/CreatedFileList';
 import CreateReceipt from './receipt/CreateReceipt';

 //import { BrowserRouter, Routes, Route } from 'react-router-dom';
 
export default class extends React.Component {
	render() {
		return (
			<div>
			{/* 	<h1>Hello....</h1>
			 <Tostify/> 
			 */}
			 
			<CreateFile/>
			<CreatedFileList/> 
			<CreateReceipt/>

			</div>
		);
	}
}