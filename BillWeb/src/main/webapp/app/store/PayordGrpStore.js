/**
 * Created by lev on 13.02.2017.
 */
Ext.define('BillWebApp.store.PayordGrpStore', {
    extend: 'Ext.data.Store',
    alias  : 'store.payordgrpstore',
    model: 'BillWebApp.model.PayordGrp',
    config:{ // перенести в модель, если нужно autoSync = false
        autoLoad: true,
        autoSync: true
    }
});