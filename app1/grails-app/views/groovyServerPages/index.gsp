<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>index</title>
    <meta name="layout" content="main">
</head>

<body>
<div id="contentWrapper" role="main">
    <h1>Index</h1>

    <div>This shows in a full page</div>
    <ul>
        <li><g:link action="html">HTML</g:link></li>
        <li><g:link action="renderHTML">renderHTML</g:link></li>
        <li><g:link action="json">JSON</g:link></li>
        <li><g:link action="renderJSON">renderJSON</g:link></li>
        <li><g:link action="markdown">Markdown</g:link></li>
        <li><g:link action="renderMarkdown">renderMarkdown</g:link></li>
        <li><g:link action="xml">XML</g:link></li>
        <li><g:link action="renderXML">renderXML</g:link></li>
        <li><g:link action="svg">SVG</g:link></li>
        <li><g:link action="renderSVG">renderSVG</g:link></li>
    </ul>
</div>
</body>
</html>