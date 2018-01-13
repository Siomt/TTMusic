package com.siomt.ttmusic.service;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.os.RemoteException;
import android.provider.MediaStore;

import com.siomt.ttmusic.utils.EncodingUtils;

import java.security.MessageDigest;

/**
 * Created by Mr.Robot on 2018/1/13.
 * https://github.com/Siomt
 */

public class SystemService {

    private Context context;
    private Cursor cursor;

    public SystemService(Context context){
        this.context = context;
    }

    public Cursor allSongs(){
        if(cursor != null){
            return cursor;
        }
        ContentResolver resolver = context.getContentResolver();
        cursor = resolver.query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,null,
                null,null, MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        return cursor;
    }

    /**
     * 读取正在播放的歌曲的艺术家
     * @return
     */
    public  String getArtist() {
        return cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
    }

    /**
     * 读取正在播放歌曲名字
     * @return 歌曲名字
     */
    public String getTitle(){
        String title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));

//        try {
//            title = EncodingUtils.getString(title.getBytes(),"UTF-8");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        return title;
    }

    /**
     * 读取正在播放歌曲的专辑
     * @return
     * @throws RemoteException
     */
    public String getAlbum() throws RemoteException{
        return cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
    }

    /**
     * 获取当前歌曲的时长
     * @return
     * @throws RemoteException
     */
//     public int getDuration() throws RemoteException{
//
//         return player.getDuration();
//     }

    /**
     * 获取当前每天时间
     * @return
     * @throws RemoteException
     */
//     public int getTime() throws RemoteException{
//         return player.getDuration();
//     }
}
