//
//  JCoreModule.m
//  UniPluginJCore
//
//  Created by huangshuni on 2021/1/21.
//

#import "JCoreModule.h"
#import "JGInforCollectionAuth.h"

@implementation JCoreModule

UNI_EXPORT_METHOD(@selector(setAuth:))

- (void)setAuth:(BOOL)enable {
    [JGInforCollectionAuth JCollectionAuth:^(JGInforCollectionAuthItems * _Nonnull authInfo) {
        authInfo.isAuth = enable;
    }];
}

@end
