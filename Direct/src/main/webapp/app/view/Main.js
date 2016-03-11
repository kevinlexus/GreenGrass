Ext.define('TestApp.view.Main', {
    extend: 'Ext.container.Container',
    requires:[
        'Ext.tab.Panel',
        'Ext.layout.container.Border',
        'TestApp.view.Pnl1'
  ],
    
    xtype: 'app-main',

    layout: {
        type: 'border'
    },

    items: [
{
        xtype: 'pnl1'
}]
});