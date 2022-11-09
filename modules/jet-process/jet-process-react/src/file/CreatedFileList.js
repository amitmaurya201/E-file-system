import React, { useState, useEffect } from 'react';
import { BsExclude } from "react-icons/bs";
import Axios from 'axios';
import { format } from 'date-fns';

const CreatedFileList = () => {

	var $ = require("jquery");
	const [docFile, setDocFile] = useState([]);
	const [formValue, setFormValue] = useState({

		userPostId: 0
	});
	const handleClickPage = (data) => {

		console.log(data.selected);

	}





	const getCreatedFileList = () => {
		Axios({
			method: 'get',
			url: `http://localhost:8080/api/jsonws/masterdata.masterdata/get-file-created-list-masterdata/user-post-id/${formValue.userPostId}?p_auth=` + Liferay.authToken
		})
			.then((result) => {
				console.log(result.data);
				setDocFile(result.data);
			})
			.catch((error) => {

				console.log(error);
			})
	}

	// useEffect(() => {
		
	// }, []);
	useEffect(() => {
		let val = document.getElementById("value").value;
		formValue.userPostId = val;
		getCreatedFileList();

	}, [	]);
	$("#value").change(function (e) {
		console.log("Jquery ......" + $("#value").val());
		formValue.userPostId = $("#value").val();
		getCreatedFileList();
	});


	return (
		<div>

			<h1 class=" text-center">File Created List</h1>
			<table className="table">
				<thead >
					<tr className='table-blue'>
						<th>S.No</th>
						<th>File No.</th>
						<th>Subject</th>
						<th>Category</th>
						<th>Created On</th>
						<th>Remark</th>

					</tr>
				</thead>
				<tbody>
					{docFile.map((docFileList, index) => {
						return (
							<tr>
								<td>{index + 1}</td>
								<td style={{ color: "blue" }}>{docFileList.fileNumber}</td>
								<td>{docFileList.subject}</td>
								<td>{docFileList.category}</td>
								<td>{format(docFileList.createDate, 'yyyy/MM/dd kk:mm')}</td>
								<td>{docFileList.remark}</td>


							</tr>)

					})}



				</tbody>
			</table>


		</div>
	);




}
export default CreatedFileList;