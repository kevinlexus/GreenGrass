/**
 * Created by lev on 13.02.2017.
 */
Ext.define('BillWebApp.model.PayordGrp', {
    extend: 'Ext.data.Model',
    idProperty: 'id',
    fields: [
        //{ name: 'id', type: 'int', convert: null},
        { name: 'id', type: 'int' , persist: false, defaultValue: 0, convert: null},
        { name: 'name', type: 'string' }/*,
        { name: 'dtf', dateFormat: 'Y-m-d H:i:s', type: 'date' },
        { name: 'username', type: 'string' }*/

    ],
    proxy: {
        autoSave: true,
        type: 'ajax',
        //type: 'rest',
        //url: 'http://192.168.100.21:8083/getPayordGrpAll',
        api: {
            create  : 'http://192.168.100.21:8083/addPayordGrp', /// хм... не работает
            read    : 'http://192.168.100.21:8083/getPayordGrpAll',
            update  : 'http://192.168.100.21:8083/setPayordGrp',
            destroy : 'http://192.168.100.21:8083/delPayordGrp'
        },
        reader: {
            type: 'json'
        },
        writer: {
            type: 'json',
            allowSingle: false/*, //запретить по одному отправлять отправлять объекты в Json - только массивом![объект] - иначе трудно описывать в Restful
            writeAllFields: true*/  //писать весь объект в json - не имеет смысла
        }
    }
});