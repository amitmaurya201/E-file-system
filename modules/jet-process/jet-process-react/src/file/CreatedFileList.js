import React, { useState, useEffect } from 'react';
import { BsExclude } from "react-icons/bs";
import Axios from 'axios';
import ReactPaginate from 'react-paginate';

const CreatedFileList = () => {


	const [docFile, setDocFile] = useState([]);
    /* const [currentPage,setCurrentPage] = useState(1);
	const [postsPerPage,setPostPerPage] = useState(8);
 */

	const handleClickPage = (data) => {
 
       console.log(data.selected);

	 }





	const getCreatedFileList = () => {
		Axios({
			method: 'get',
			url: 'http://localhost:8080/api/jsonws/jet_process.docfile/get-doc-file-list/?p_auth=' + Liferay.authToken
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

	/*     const lastPostIndex = currentPage * postsPerPage; */
	/* 	const  firstPostIndex = lastPostIndex - postsPerPage;

		const currentPosts = docFile.slice(firstPostIndex,lastPostIndex);
 */
	return (
		<div>
			

			<table className="table">
				<thead >
					<tr className='table-blue'>
						<th>S.No</th>
						<th>File No.</th>
						<th>Subjet</th>
						<th>Category</th>
						<th>subCatagory</th>
						<th>Created On</th>
						<th>Remarks</th>
						<th>Edit/Download</th>
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
								<td>{docFileList.subCategory}</td>
								{/* <td>{docFileList.createDate}</td> */}
								<td>{docFileList.remarks}</td>
								{<BsExclude/>}
							</tr>)
					})}


				</tbody>
			</table>

			<ReactPaginate 
					previousLabel={'previous'}
					nextLabel={'next'}
					breakLabel={'...'}
					pageCount={15}
					marginPagesDisplayed={3}
					onPageChange={handleClickPage}
					containerClassName={'pagination justify-content-center'}
					pageClassName={'page-item'}
					pageLinkClassName={'page-link'}
                    previousClassName={'page-item'}
					previousLinkClassName={'page-link'}
                    nextClassName={'page-item'}
					nextLinkClassName={'page-link'}
					breakClassName={'page-item'}
					breakLinkClassName={'page-link'}
					activeClassName={'active'}



					/>		
		</div>
	);


	

}
export default CreatedFileList