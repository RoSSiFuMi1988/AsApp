package store.active.asapp.runtime_permission;

import android.support.v4.app.ActivityCompat;


public interface IPermissionManager extends ActivityCompat.OnRequestPermissionsResultCallback {

    void managingPermission();
}
