/**
 * Created by lev on 13.03.2017.
 */
Ext.define('BillWebApp.model.PayordCmp', {
    extend: 'Ext.data.Model',
    fields: [
        { name: 'id', type: 'int', convert: null, persist: false},
        { name: 'dtf', dateFormat: 'Y-m-d H:i:s', type: 'date', persist: false},
        { name: 'username', type: 'string', persist: false},
        { name: 'payordFk', type: 'int', convert: null},
        { name: 'varFk', type: 'int', convert: null},
        { name: 'servFk', type: 'int', convert: null},
        { name: 'orgFk', type: 'int', convert: null},
        { name: 'areaFk', type: 'int', convert: null},
        { name: 'mark', type: 'string' },
        { name: 'summa', type: 'float', persist: false }],
        proxy: {
            type: 'ajax',
            api: {
            create  : '',
                create  : 'http://192.168.100.21:8083/payord/addPayordCmp',
                read    : 'http://192.168.100.21:8083/payord/getPayordCmp',
                update  : 'http://192.168.100.21:8083/payord/setPayordCmp',
                destroy : 'http://192.168.100.21:8083/payord/delPayordGrp'
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
    }
});