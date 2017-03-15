/**
 * Created by lev on 13.02.2017.
 */
Ext.define('BillWebApp.store.PayordStore', {
    extend: 'Ext.data.Store',
    alias  : 'store.payordstore',
    model: 'BillWebApp.model.Payord',
    config:{
        autoLoad: true,
        autoSync: true
    },
    proxy: {
        autoSave: false,
        type: 'ajax',
        api: {
            create  : '',
            read    : 'http://192.168.100.21:8083/getPayord',
            update  : 'http://192.168.100.21:8083/setPayord',
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