<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>VenturePrime</title>
        <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.3.0/build/cssreset/reset-min.css" />
        <link rel="stylesheet" type="text/css" href="/assets/css/smoothness/jquery-ui-1.8.22.custom.css" />
        <link rel="stylesheet" type="text/css" href="/assets/css/style.css" />
    	<script type="text/javascript" src="/assets/js/jquery-1.7.2.min.js"></script>
    	<script type="text/javascript" src="/assets/js/jquery-ui-1.8.22.custom.min.js"></script>
        <!--[if gte IE 9]>
            <style type="text/css">
                .gradient {
                    filter: none;
                }
            </style>
        <![endif]-->
    </head>
    <body>
        <header id="vp-header" style="padding: 5px">
            <div style="float:right">
                <div style="display: inline-block; vertical-align: middle">
                    <nav id="Nav1" style="padding: 0; margin: 0; margin-right: 10px">
                        <a class="upper" href="/companies">companies</a>
                        <a class="upper" href="/prizes">prizes</a>
                        <a class="upper" href="/the-fame">primer hall of fame</a>
                        <a class="upper" href="/guide">how it works</a>
                        <a class="upper" href="/about">about</a>
                        <a class="upper" href="/contact">contact</a>
                    </nav>
                </div>
                <div style="display: inline-block">
                    <nav>
                    	<c:choose>
						    <c:when test="${user != null}">
						    	<a href="/logout">Logout</a>
						    </c:when>
						    <c:otherwise>
						    	<a href="/login">Login</a>
						    	<a href="/register">Register</a>
							</c:otherwise>
						</c:choose>
                    </nav>
                </div>
            </div>
            <div style="float: left; width: 100px">
                <div style="display: inline-block; width: 75px; font-weight: bold">
                    <span style="color:black">Venture</span><span style="color:skyblue">Prime</span>
                </div>
                <div style="display: inline-block; width: 1px;">&nbsp;</div>
            </div>
            <div style="clear: both; height: 0px">&nbsp;</div>
        </header>
        <div id="vp-content-contain" style="min-height: 150px;margin-bottom: 50px">
            <div style="margin: 5px; padding: 5px;">