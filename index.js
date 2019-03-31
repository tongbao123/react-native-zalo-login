
import { NativeModules, NativeEventEmitter } from 'react-native';

const { RNZaloLogin } = NativeModules;
const RNZBridgeEmitter = new NativeEventEmitter(RNZaloLogin)
module.exports = {RNZaloLogin, RNZBridgeEmitter}
