<#macro table caption>
    <ul>
        <div id="main_activity_table">
            <div id="scroll-table">
                <table>
                    <caption>${caption}:</caption>
                    <thead>
                    <tr>
                        <@thead/>
                    </tr>
                    </thead>
                </table>
            </div>
            <div id="scroll-table-body">
                <table>
                    <tbody>
                    <@tbody/>
                    </tbody>
                </table>
            </div>
        </div>
    </ul>
</#macro>