using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Zalo.Login.RNZaloLogin
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNZaloLoginModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNZaloLoginModule"/>.
        /// </summary>
        internal RNZaloLoginModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNZaloLogin";
            }
        }
    }
}
