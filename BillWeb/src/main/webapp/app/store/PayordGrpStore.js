/**
 * Created by lev on 13.02.2017.
 */
Ext.define('BillWebApp.store.PayordGrpStore', {
    extend: 'Ext.data.Store',
    alias  : 'store.payordgrpstore',
    //storeId: 'payordgrpstore',
    model: 'BillWebApp.model.PayordGrp',
    config:{
        autoLoad: true,
        autoSync: true
    },
    idProperty: 'id'
});