# Studying Notebooks

This repo is that I collected and practiced on jupyter notebook from many blogs or books. The links have mentioned on the top of notebooks for the credits of authors.

## Usages

I use docker to create the environment, you can use the follow code to initialize the environment.

``` bash
git clone git://github.com/wadehuang36/notebooks

docker run -d --name notebooks -v ./notebooks:/notebooks -p 8888:8888 kaggle/python /bin/bash -c "jupyter notebook --notebook-dir=/notebooks --allow-root --ip='*' --port=8888 --no-browser"

#!! on windows, the path of the mounted volume have to use absolute path such as -v ${pwd}/notebooks:/notebooks !!

## for first time
docker logs notebooks 
# you can see the token in the logs which is for login

## open in browser
http://localhost:8888

## restart 
docker start notebooks
```

Kaggle has provide a python image which has included a lot of machine learning packages such as numpy and sklearn. It saves a lot of time to create a brand-new environment by ourselves. I recommend you can you it as well.

### TensorBoard

[TenserBoard](https://github.com/tensorflow/tensorflow/blob/r1.2/tensorflow/tensorboard/README.md) is Visualization Tool of TenserFlow, if you want to use TensorBoard, you can use this commend to start the service.

```
docker run -d --name tensorboard -v ./notebooks:/notebooks -p 6006:6006 kaggle/python /bin/bash -c "tensorboard --logdir=/notebooks/.tensorflow-logs"
```