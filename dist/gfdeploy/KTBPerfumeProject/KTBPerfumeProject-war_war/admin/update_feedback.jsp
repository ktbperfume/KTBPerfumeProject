<%@include file="admin_header.jsp" %>
<%@include file="admin_left.jsp" %>
<div class="row">
    <div class="col-md-8 col-xs-12">
        <center>
            <h3 class="box-title">Update Brand</h3>
        </center>
        <code><a href="admin_manage_brand.jsp">List Brand</a></code>

        <form class="form-horizontal form-material" action="./updateFeedbackServlet" method="post" >
            <div class="form-group">
                <label class="col-md-12">Feedback Id</label>
                <div class="col-md-12">
                    <input value="${b.feedbackId}" type="hidden" class="form-control form-control-line" name="feedbackId"/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-12">From</label>
                <div class="col-md-12">
                    <input value="${b.customerId.customerId}" class="form-control form-control-line" readonly/>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-12">Subject</label>
                <div class="col-md-12">
                    <input value="${b.subject}" type="text" class="form-control form-control-line" name="subject" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-12">Content</label>
                <textarea class="form-control" rows="4" style="margin-left: 12px"  name="content">${b.content}</textarea>
            </div>
            <div class="form-group">
                <label class="col-md-12">Admin</label>
                <div class="col-md-12">
                    <input value="${b.username.username}" type="text" class="form-control form-control-line" name="username" readonly>
                </div>
            </div>
            <div class="form-group">
                <label class="col-md-12">reply</label>
                <textarea class="form-control" rows="4" style="margin-left: 12px"  name="reply">${b.reply}</textarea>
            </div>
            
            <div class="form-group">
                <label class="col-md-12">day send</label>
                <div class="col-md-12">
                    <input value="${b.date}" type="text" class="form-control form-control-line" name="date"  readonly> </div>
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-12">
                    <button class="btn btn-success" type="submit">Update</button>&emsp;
                    <button class="btn btn-danger">Reset</button>
                </div>
            </div>
        </form>
    </div>
</div>
<%@include file="admin_fooder.jsp" %>
