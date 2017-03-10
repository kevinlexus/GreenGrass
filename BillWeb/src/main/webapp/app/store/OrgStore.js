/**
 * Created by lev on 09.03.2017.
 */
Ext.define('BillWebApp.store.OrgStore', {
    extend: 'Ext.data.Store',
    alias  : 'store.orgstore',
    storeId: 'OrgStore',
    model: 'BillWebApp.model.Org',
    config:{
        autoLoad: true,
        autoSync: true
    },
    proxy: {
        autoSave: false,
        type: 'ajax',
        api: {
            create  : '',
            read    : 'http://192.168.100.21:8083/getOrgCurUser',
            update  : '',
            destroy : ''
        },
        reader: {
            type: 'json'
        },
        extraParams :{
            roleCd : 'MainReports.ArmBuhg',
            actCd : 'Загрузить в контрол'
        }
    }
});