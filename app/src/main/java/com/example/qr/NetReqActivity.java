package com.example.qr;

public class NetReqActivity {
    /*
    private static NetReqActivity instance;
    private RequestQueue requestQueue;
    private ImageLoader imageLoader;
    private static Context cxt;

    private NetReqActivity(Context context) {
        cxt = context;
        requestQueue = getRequestQueue();

        imageLoader = new ImageLoader(requestQueue,
                new ImageLoader.ImageCache() {
            private final LruCache<String, Bitmap>
                    cache = new LruCache<String, Bitmap>(20);

            @Override
            public Bitmap getBitmap(String url) {
                return cache.get(url);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {
                cache.put(url,bitmap);
            }
        });

        public static synchronized NetReqActivity getInstance(Context context){
            if (instance == null) {
                instance = new NetReqActivity(context);
            }
            return instance;
        }

        public RequestQueue getRequestQueue() {
            if(requestQueue == null) {
                requestQueue = Volley.newRequestQueue(cxt.getApplicationContext());
            }
            return requestQueue;
        }

        public <T> void addToRequestQueue(Request<T> req) {
            getRequestQueue().add(req);
        }

        public ImageLoader getImageLoader() {
            return imageLoader;
        }
    }*/

}
