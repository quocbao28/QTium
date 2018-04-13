package Android;

import org.openqa.selenium.By;

public class IssueScreenEntity extends AndroidScreenEntity {

	public static By Id = ByUIA("resourceId", "com.logigear.scrumboard:id/txtId");
	public static By Title = ByUIA("resourceId", "com.logigear.scrumboard:id/txtTitle");
	public static By Description = ByUIA("resourceId", "com.logigear.scrumboard:id/txtDescription");
	public static By Priority = ByUIA("resourceId", "com.logigear.scrumboard:id/spPriority");
	public static By Component = ByUIA("resourceId", "com.logigear.scrumboard:id/spComponent");
	public static By Status = ByUIA("resourceId", "com.logigear.scrumboard:id/spStatus");
	public static By Estimate = ByUIA("resourceId", "com.logigear.scrumboard:id/txtEstimate");
	public static By Spent = ByUIA("resourceId", "com.logigear.scrumboard:id/txtSpent");
	public static By Assignee = ByUIA("resourceId", "com.logigear.scrumboard:id/txtAssignee");
	
	public static By Label_Title = ByUIA("resourceId", "com.logigear.scrumboard:id/textView0");
	public static By Label_Id = ByUIA("resourceId", "com.logigear.scrumboard:id/textView1");
	public static By Label_Description = ByUIA("resourceId", "com.logigear.scrumboard:id/textView2");
	public static By Label_Estimate = ByUIA("resourceId", "com.logigear.scrumboard:id/textView3");
	public static By Label_Spent = ByUIA("resourceId", "com.logigear.scrumboard:id/textView4");
	public static By Label_Assignee = ByUIA("resourceId", "com.logigear.scrumboard:id/textView5");
	public static By Label_ComponentId = ByUIA("resourceId", "com.logigear.scrumboard:id/textView6");
	public static By Label_PriorityId = ByUIA("resourceId", "com.logigear.scrumboard:id/textView7");
	public static By Label_StatusId = ByUIA("resourceId", "com.logigear.scrumboard:id/textView8");
	
	public static By Save = ByUIA("description", "Save");
	public static By Edit = ByUIA("description", "Edit");
	public static By Delete = ByUIA("description", "Delete");
	public static By SaveEdit = ByUIA("description", "SaveEdit");
	public static By Cancel = ByUIA("description", "Cancel");
	
	public static By Message = ByUIA("resourceId", "android:id/message");
	public static By MessageOK = ByUIA("text", "OK");
	
	public static By DeleteConfirmButton = ByUIA("text", "Yes");
	
	public static By SelectAll = ByUIA("resourceId", "android:id/selectAll");
}
