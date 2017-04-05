/**
 * This class is the controller for the main view for the application. It is specified as
 * the "controller" of the Main view class.
 *
 * TODO - Replace this content of this view to suite the needs of your application.
 */
Ext.define('BillWebApp.view.main.AskObjPanelController', {
    extend: 'Ext.app.ViewController',
    alias: 'controller.askobjpanelcontroller',

    // В AskObjPanel: Обновить грид, при нажатии кнопки поиска
    onAskObjButtonFindPress: function() {
        var askObjComboAdrTp = this.lookupReference('askObjComboAdrTp');
        var koAddrTpStore = this.getViewModel().getStore('koAddrTpStore');
        var askObjName = this.lookupReference('askObjName');
        koAddrTpStore.load({params: {
            'addrTp': askObjComboAdrTp.getValue(),
            'flt': askObjName.getValue()
        }});
    },

    // В AskObjPanel: Записать новое значение в поле грида, при нажатии кнопки выбора
    onAskObjButtonSelPress: function() {
        var koAddrTpStore = this.getViewModel().getStore('koAddrTpStore');
        var models1 = koAddrTpStore.getRange();

        this.fireEvent('something', this, models1[0].get('id'));
        askObjPanel.destroy();

    }
});
