package com.ss.lms.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ss.lms.dao.BookCopyDataAccess;
import com.ss.lms.dao.BookLoanDataAccess;
import com.ss.lms.dao.BorrowerDataAccess;
import com.ss.lms.dao.LibraryBranchDataAccess;
import com.ss.lms.entity.BookCopy;
import com.ss.lms.entity.BookCopyCompositeKey;
import com.ss.lms.entity.BookLoan;
import com.ss.lms.entity.BookLoanCompositeKey;
import com.ss.lms.entity.Borrower;
import com.ss.lms.entity.LibraryBranch;

@Component
public class BorrowerService {

	
	@Autowired
	private LibraryBranchDataAccess libraryBranchDao;
	@Autowired
	private BorrowerDataAccess borrowerDao;
	@Autowired
	private BookLoanDataAccess bookLoanDao;
	@Autowired
	private BookCopyDataAccess bookCopyDao;
	
	/*************************************************
	 * 
	 * ALL CREATE AND UPDATE OPERATIONS
	 * 
	 *************************************************/

	public Borrower saveBorrower(Borrower borrower)
	{
		return borrowerDao.save(borrower);
	}
	
	public BookCopy saveBookCopy(BookCopy copies) {
		return bookCopyDao.save(copies);
	}
	
	public BookLoan saveBookLoan(BookLoan bookLoan) 
	{
		return bookLoanDao.save(bookLoan);
	}
	
	
	/*************************************************
	 * 
	 * ALL READ OPERATIONS
	 * 
	 *************************************************/


	public Optional<LibraryBranch> readLibraryBranchById(Integer branchId){
		return libraryBranchDao.findById(branchId);
	}

	public Iterable<LibraryBranch> readAllLibraryBranch(){
		return libraryBranchDao.findAll();
	}
	
	public Optional<Borrower> readBorrowerById(Integer cardNo){
		return borrowerDao.findById(cardNo);
	}

	public Iterable<Borrower> readBorrowerAll(){
		return borrowerDao.findAll();
	}

	public Optional<BookLoan> readBookLoanById(BookLoanCompositeKey bookLoanCompositeKey){
		return bookLoanDao.findById(bookLoanCompositeKey);
	}

	public Iterable<BookLoan> readAllBookLoan()
	{
		return bookLoanDao.findAll();
	}

	public Optional<BookCopy> readBookCopyById(BookCopyCompositeKey bookCopyCompositeKey){
		System.out.println(bookCopyDao.findById(bookCopyCompositeKey));
		return bookCopyDao.findById(bookCopyCompositeKey);
	}
	
	public Iterable<BookCopy> readAllCopy(){
		return bookCopyDao.findAll();
	}
	
	/*************************************************
	 * 
	 * ALL DELETE OPERATIONS
	 * 
	 *************************************************/

	
	public void deleteBookloan(Integer cardNo, Integer branchId, Integer bookId ) {
		bookLoanDao.deleteById(new BookLoanCompositeKey(cardNo, branchId, bookId));
	}

}
