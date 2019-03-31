
#import "RNZaloLogin.h"
#include <ZaloSDK/ZaloSDK.h>
#import <UIKit/UIKit.h>

@implementation RNZaloLogin


RCT_EXPORT_MODULE();
-(NSArray<NSString*> *) supportedEvents{
    return @[@"EventZaloLogin"];
}

RCT_EXPORT_METHOD(login:(RCTResponseSenderBlock)callback){
    [[ZaloSDK sharedInstance] authenticateZaloWithAuthenType:ZAZaloSDKAuthenTypeViaZaloAppOnly
                              parentController:self
                              handler:^(ZOOauthResponseObject *response) {
    if([response isSucess]) {
        
       NSMutableDictionary *userObj = [[NSMutableDictionary alloc] init];
       [userObj setObject:response.oauthCode forKey:@"oauthCode"];
       [userObj setObject:response.userId forKey:@"userId"];
       [userObj setObject:response.displayName forKey:@"displayName"];
       callback(@[[NSNull null], userObj]);
                                                             
        
    } else if(response.errorCode != kZaloSDKErrorCodeUserCancel) {
        
    }
    }];
}
@end
  
