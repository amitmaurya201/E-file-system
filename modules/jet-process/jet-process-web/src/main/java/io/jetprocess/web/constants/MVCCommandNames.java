package io.jetprocess.web.constants;

public class MVCCommandNames {

	//create and created list render command name
	public static final String CREATE_FILE_RENDER_COMMAND = "/createFile";
	public static final String CREATE_RECEIPT_RENDER_COMMAND = "/createReceipt";
	public static final String VIEW_FILE_LIST_RENDER_COMMAND = "/createdFileList";
	public static final String VIEW_RECEIPT_LIST_RENDER_COMMAND = "/createdListReceipt";

	//userpost
	public static final String SET_USER_POST_ACTION_COMMAND = "/set/user/post/action/command";
	
	// --for inner view of file
	public static final String FILE_DETAILS_RENDER_COMMAND = "/fileDetails";
	public static final String FILE_MOVEMENT_RENDER_COMMAND = "/fileMovement";
	public static final String EDIT_FILE_RENDER_COMMAND = "/editFile";
	public static final String PUT_IN_FILE_RENDER_COMMAND = "/PutInFile";
	public static final String CORRESPONCE_FILE_RENDER = "/addCorrespondence";
//	public static final String ATTACH_FILE_CORRESPONDENCE_RENDER_COMMAND = "/AttachFileCorrespondence";
	public static final String FILE_SEND_RENDER_COMMAND = "/fileSend";
	public static final String FILE_SEND_ACTION_COMMAND = "/sendFile";
	
	// --for inner view of receipt
	public static final String RECEIPT_DETAILS_RENDER_COMMAND = "/receiptDetails";
	public static final String RECEIPT_MOVEMENT_RENDER_COMMAND = "/receiptMovement";
	public static final String RECEIPT_SEND_RENDER_COMMAND = "/sendReceipt";
	public static final String RECEIPT_SEND_ACTION_COMMAND = "/sendReceiptAction";
	public static final String EDIT_RECEIPT_RENDER_COMMAND = "/editReceipt";

	// -for sent receipt and file
	public static final String FILE_SENT_RENDER_COMMAND = "/fileSentBox";
	public static final String PULL_BACK_FILE_ACTION_COMMAND = "/pull-back-file/action/command";
	public static final String RECEIPT_SENT_RENDER_COMMAND = "/receiptSent";
	public static final String PULL_BACK_RECEIPT_ACTION_COMMAND = "/receiptSentActionURL";

	// -for inbox receipt and file
	public static final String FILE_INBOX_RENDER_COMMAND = "/fileInbox";
	public static final String FILE_INBOX_READ_ACTION_COMMAND = "/fileReadAction";
	public static final String FILE_INBOX_RECEIVE_ACTION_COMMAND = "/fileReceiveAction";
	public static final String FILE_SEND_CHECKER_ACTION_COMMAND = "/sendURL";
	public static final String RECEIPT_INBOX_RENDER_COMMAND = "/receiptInbox";
	public static final String RECEIPT_INBOX_READ_ACTION_COMMAND = "/receiptReadAction";
	public static final String RECEIPT_INBOX_RECEIVE_ACTION_COMMAND = "/receiptReceiveAction";
	public static final String RECEIPT_SEND_CHECKER_ACTION_COMMAND = "/sendReceiptURL";

}
