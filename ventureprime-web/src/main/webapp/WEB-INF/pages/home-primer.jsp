<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<jsp:include page="include-header.jsp" />
                <div style="width: 1000px">
                    <div>
                        <div style="float: right">You have 802 VenturePoints</div>
                        <div style="clear: right; height: 0px;">&nbsp;</div>
                    </div>
                    <div style="display:inline-block; vertical-align: top;">
                        <div>
                            <div style="display: inline-block; width: 80px; height: 80px; border: 1px solid gray;"><a href="/p/tests/new">New Tests</a></div>
                            <div style="display: inline-block; width: 80px; height: 80px; border: 1px solid gray;"><a href="/p/tests/new">My Tests</a></div>
                            <div style="display: inline-block; width: 80px; height: 80px; border: 1px solid gray;"><a href="/p/prizes">My Prizes</a></div>
                            <div style="display: inline-block; width: 80px; height: 80px; border: 1px solid gray;"><a href="/p/friends">Friends</a></div>
                            <div style="display: inline-block; width: 80px; height: 80px; border: 1px solid gray;"><a href="/p/inbox">Inbox</a></div>
                        </div>
                        <div style="margin: 10px">
                            <h1>Welcome ${user.id}</h1>
                            <p>You're a <b>primer</b>.</p>
                        </div>
                    </div>
                    <div style="display:inline-block; vertical-align: top">
                        <div>
                            <h5 style="background-color: gainsboro; font-weight: bold; padding: 2px;">Feed</h5>
                            <div>blah</div>
                            <div>blah</div>
                            <div>blah</div>
                            <div>blah</div>
                            <div>blah</div>
                            <div>blah</div>
                        </div>
                        <div style="margin-top: 10px;">
                            <h3 style="background-color: gainsboro; font-weight: bold; padding: 2px;">VenturePrime Company Spotlight</h3>
                            <div>
                                <div>Update 1</div>
                                <div>Update 2</div>
                                <div>Update 3</div>
                                <div>Update 4</div>
                                <div>Update 5</div>
                            </div>
                        </div>
                    </div>
                </div>
<jsp:include page="include-footer.jsp" />