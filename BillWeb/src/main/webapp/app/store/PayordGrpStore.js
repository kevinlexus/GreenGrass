/**
 * Created by lev on 13.02.2017.
 */
Ext.define('BillWebApp.store.PayordGrpStore', {
    extend: 'Ext.data.Store',
    alias  : 'store.payordgrpstore',
    model: 'BillWebApp.model.PayordGrp',
    config:{
        autoLoad: true,
        autoSync: true
    },
    proxy: {
        autoSave: false,
        type: 'ajax',
        api: {
            create  : '',
            read    : 'http://192.168.100.21:8083/getPayordGrp',
            update  : 'http://192.168.100.21:8083/setPayordGrp',
            destroy : ''
        },
        reader: {
            type: 'json'
        },
        writer: {
            type: 'json',
            allowSingle: false //запретить по одному отправлять отправлять объекты в Json - только массивом![объект] - иначе трудно описывать в Restful
                ,
             writeAllFields: true  //писать весь объект в json - не имеет смысла
        }
    }
});