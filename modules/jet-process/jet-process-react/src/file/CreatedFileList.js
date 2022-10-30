import React, { useState, useEffect } from 'react';
import { BsExclude } from "react-icons/bs";
import Axios from 'axios';
import ReactPaginate from 'react-paginate';

const CreatedFileList = () => {


	const [docFile, setDocFile] = useState([]);
	const [docFile1, setDocFile1] = useState([]);
	
    /* const [currentPage,setCurrentPage] = useState(1);
	const [postsPerPage,setPostPerPage] = useState(8);
 */

	const handleClickPage = (data) => {
 
       console.log(data.selected);

	 }





	const getCreatedFileList = () => {
		Axios({
			method: 'get',
			url: 'http://localhost:8080/api/jsonws/masterdata.masterdata/get-file-masterdata/?p_auth=' + Liferay.authToken
		})
			.then((result) => {
				console.log(result.data);
				setDocFile(result.data);
			})
			.catch((error) => {

				console.log(error);
			})
	}
	const getCreatedFileList1 = () => {
		Axios({
			method: 'get',
			url: 'http://localhost:8080/api/jsonws/masterdata.masterdata/get-file-masterdata1/?p_auth=' + Liferay.authToken
		})
			.then((result) => {
				console.log(result.data);
				setDocFile1(result.data);
			})
			.catch((error) => {

				console.log(error);
			})
	}
	
	useEffect(() => {

		getCreatedFileList();
		getCreatedFileList1();
		
	}, []);

	/*     const lastPostIndex = currentPage * postsPerPage; */
	/* 	const  firstPostIndex = lastPostIndex - postsPerPage;

		const currentPosts = docFile.slice(firstPostIndex,lastPostIndex);
 */
	return (
		<div>
			
            <h1 class=" text-center">File View Details</h1>
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
								{docFile1.map((docFileList1, index) => {
						return (
							
								<tr>
									
								<td>{docFileList1.subcategory}</td>
								</tr>
								
							)
					})}
								
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