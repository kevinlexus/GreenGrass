/**
 * Created by lev on 13.02.2017.
 */
Ext.define('BillWebApp.store.PayordCmpStore', {
    extend: 'Ext.data.Store',
    alias  : 'store.payordcmpstore',
    storeId: 'payordcmpstore',
    model: 'BillWebApp.model.PayordCmp',
    proxy: {
        autoSave: false,
        type: 'ajax',
        api: {
            create  : '',
            read    : 'http://192.168.100.21:8083/payord/getPayordCmp',
            update  : 'http://192.168.100.21:8083/payord/setPayordCmp',
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
        },
        extraParams :{
            payordId: -1
        }
    },
    config:{// перенести в модель, если нужно autoSync = false
        autoLoad: false,
        autoSync: true
    }

});