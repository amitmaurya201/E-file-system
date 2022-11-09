import React, { useState, useEffect } from 'react';
import { BsExclude } from "react-icons/bs";
import Axios from 'axios';
import { format } from 'date-fns';
import { useNavigate } from 'react-router-dom';

const CreatedFileList = () => {
	const navigate = useNavigate();

	const [docFile, setDocFile] = useState([]);

	const handleClick = (e) => {
		console.log(e.selected);
		const receiptId = e.target.value;
		console.log(receiptId);
		navigate("/web/jet-process/8fbbe737-5dca-5154-f69b-7bab24f2e8b6/-/jetprocessreact_INSTANCE_ssvp/create-receipt/" + receiptId);
	}
	const getCreatedFileList = () => {
		Axios({
			method: 'get',
			url: 'http://localhost:8080/api/jsonws/masterdata.masterdata/get-receipt-list-masterdata/?p_auth=' + Liferay.authToken
		})
			.then((result) => {
				console.log(result.data);
				setDocFile(result.data);
			})
			.catch((error) => {

				console.log(error);
			})
	}
	useEffect(() => {

		getCreatedFileList();

	}, []);

	return (
		<div>

			<h1 class=" text-center">Receipt View Details</h1>
			<table className="table">
				<thead >
					<tr className='table-blue'>
						<th>S.No</th>
						<th>File No.</th>
						<th>Subject</th>
						<th>Category</th>
						<th>Created On</th>
						<th>Remark</th>
						<th>Operation</th>
					</tr>
				</thead>
				<tbody>
					{docFile.map((docFileList, index) => {
						return (
							<tr>
								<td>{index + 1}</td>
								<td style={{ color: "blue" }}>{docFileList.receiptNumber}</td>
								<td>{docFileList.subject}</td>
								<td>{docFileList.category}</td>
								<td>{format(docFileList.createDate, 'dd/mm/yyyy')}</td>
								<td>{docFileList.remark}</td>
								<td><button className='btn btn-success' value={docFileList.receiptId} onClick={handleClick}>Update</button></td>
							</tr>)
					})}
				</tbody>
			</table>
		</div>
	);
}
export default CreatedFileList;