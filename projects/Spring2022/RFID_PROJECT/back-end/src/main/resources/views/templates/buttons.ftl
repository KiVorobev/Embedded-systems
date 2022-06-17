<#macro buttons leftFunction rightFunction leftName rightName>
    <div id="buttons">
        <button onclick="${leftFunction}">${leftName}</button>
        <button id="right_button" onclick="${rightFunction}">${rightName}</button>
    </div>
</#macro>