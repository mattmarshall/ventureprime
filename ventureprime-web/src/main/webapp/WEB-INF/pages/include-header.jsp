<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <title>VenturePrime</title>
        <link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.3.0/build/cssreset/reset-min.css" />
        <style type="text/css">
            html * {
                font-family: Helvetica, Arial, sans-serif;
            }
            
            a.upper {
                text-transform: uppercase;
            }
            
            body 
            {
                height: 100%;
                min-width: 1000px;
            }
            
            header#vp-header 
            {
                margin: 0;
                padding: 10px;
                border-bottom: 1px solid #aaa;
                
                background: #ffffff; /* Old browsers */
                /* IE9 SVG, needs conditional override of 'filter' to 'none' */
                background: url(data:image/svg+xml;base64,PD94bWwgdmVyc2lvbj0iMS4wIiA/Pgo8c3ZnIHhtbG5zPSJodHRwOi8vd3d3LnczLm9yZy8yMDAwL3N2ZyIgd2lkdGg9IjEwMCUiIGhlaWdodD0iMTAwJSIgdmlld0JveD0iMCAwIDEgMSIgcHJlc2VydmVBc3BlY3RSYXRpbz0ibm9uZSI+CiAgPGxpbmVhckdyYWRpZW50IGlkPSJncmFkLXVjZ2ctZ2VuZXJhdGVkIiBncmFkaWVudFVuaXRzPSJ1c2VyU3BhY2VPblVzZSIgeDE9IjAlIiB5MT0iMCUiIHgyPSIwJSIgeTI9IjEwMCUiPgogICAgPHN0b3Agb2Zmc2V0PSIxJSIgc3RvcC1jb2xvcj0iI2ZmZmZmZiIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjMzJSIgc3RvcC1jb2xvcj0iI2VmZWZlZiIgc3RvcC1vcGFjaXR5PSIxIi8+CiAgICA8c3RvcCBvZmZzZXQ9IjEwMCUiIHN0b3AtY29sb3I9IiNlNWU1ZTUiIHN0b3Atb3BhY2l0eT0iMSIvPgogIDwvbGluZWFyR3JhZGllbnQ+CiAgPHJlY3QgeD0iMCIgeT0iMCIgd2lkdGg9IjEiIGhlaWdodD0iMSIgZmlsbD0idXJsKCNncmFkLXVjZ2ctZ2VuZXJhdGVkKSIgLz4KPC9zdmc+);
                background: -moz-linear-gradient(top,  #ffffff 1%, #efefef 33%, #e5e5e5 100%); /* FF3.6+ */
                background: -webkit-gradient(linear, left top, left bottom, color-stop(1%,#ffffff), color-stop(33%,#efefef), color-stop(100%,#e5e5e5)); /* Chrome,Safari4+ */
                background: -webkit-linear-gradient(top,  #ffffff 1%,#efefef 33%,#e5e5e5 100%); /* Chrome10+,Safari5.1+ */
                background: -o-linear-gradient(top,  #ffffff 1%,#efefef 33%,#e5e5e5 100%); /* Opera 11.10+ */
                background: -ms-linear-gradient(top,  #ffffff 1%,#efefef 33%,#e5e5e5 100%); /* IE10+ */
                background: linear-gradient(to bottom,  #ffffff 1%,#efefef 33%,#e5e5e5 100%); /* W3C */
                filter: progid:DXImageTransform.Microsoft.gradient( startColorstr='#ffffff', endColorstr='#e5e5e5',GradientType=0 ); /* IE6-8 */

            }
            
            a.upper {
                text-decoration: none;
                margin: 0 5px;
                margin-bottom: 3px;
            }
            
            a.upper:hover {
                text-decoration: underline;
            }
            
            span#vp-logo {
                font-size: 20px;
            }
            
            span#vp-logo span 
            {
                display: inline-block;
                margin: 0;
                padding: 0;
            }
            
            div#vp-logo-contain {
                display: inline-block;
                width: 150px;
            }
            
            div#vp-nav-contain 
            {
                display: inline-block;
                vertical-align: middle;
            }
            
            div#vp-user-card-contain 
            {
                display: inline-block;
                vertical-align: middle;
                margin: 0 15px;
            }
            
            div#vp-header-right {
                float: right;
            }
            
            .venture {
                font-weight: bold;
                vertical-align: bottom;
            }
            
            .prime {
                font-weight: bold;
                color: skyblue;
                position: relative;
                left: -5px;
                vertical-align: bottom;
            }
            
        </style>
        
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
                        <a href="/login">Login</a>
                        <a href="/register">Register</a>
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