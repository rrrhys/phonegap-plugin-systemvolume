var exec = require('cordova/exec');

module.exports = {

    setSystemVolume: function(volume) {
        exec(null, null, "SystemVolume", "setSystemVolume", [volume]);
    },
        getSystemVolume: function(sucessCallback) {
        return cordova.exec(sucessCallback, errorCallback, "SystemVolume", "getSystemVolume", []);
            
        }
};
