Ext.define('TestApp.view.Pnl1', {
    extend: 'Ext.grid.Panel',

    xtype : 'pnl1',   
    store: 'Store1',

    selType: 'checkboxmodel',
    columns: [
        {text: "Company", width: 300, dataIndex: 'name'},
        {text: "Price", formatter: 'usMoney', dataIndex: 'price'},
        {text: "Change", dataIndex: 'change'},
        {text: "% Change", dataIndex: 'pctChange'},
        {text: "Last Updated", width: 120, formatter: 'date("m/d/Y")', dataIndex: 'lastChange'}
    ],
    columnLines: true,
    height: 450,
    frame: true,
    title: 'Framed with Checkbox Selection and Horizontal Scrolling',

    initComponent: function() {
        this.width = 1000;
        this.callParent();
    }
});

