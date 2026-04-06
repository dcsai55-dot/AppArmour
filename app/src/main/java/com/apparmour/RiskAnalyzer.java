package com.apparmour;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

public class RiskAnalyzer {

    public static String analyze(String packageName, PackageManager pm) {

        try {
            PackageInfo info = pm.getPackageInfo(
                    packageName,
                    PackageManager.GET_PERMISSIONS
            );

            String[] permissions = info.requestedPermissions;
            int risk = 0;

            if (permissions != null) {
                for (String perm : permissions) {

                    if (perm.contains("SMS")) risk += 2;
                    if (perm.contains("READ_CONTACTS")) risk += 1;
                    if (perm.contains("INTERNET")) risk += 1;
                }
            }

            if (packageName.contains("loan") || packageName.contains("bank")) {
                risk += 2;
            }

            if (risk >= 4) return "DANGEROUS";
            else if (risk >= 2) return "SUSPICIOUS";
            else return "SAFE";

        } catch (Exception e) {
            return "UNKNOWN";
        }
    }
}
