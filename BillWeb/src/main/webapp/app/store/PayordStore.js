/**
 * Created by lev on 13.02.2017.
 */
Ext.define('BillWebApp.store.PayordStore', {
    extend: 'Ext.data.Store',
    alias  : 'store.payordstore',
    model: 'BillWebApp.model.Payord',
    autoLoad: true,
    autoSync: false

});