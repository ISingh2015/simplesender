Start the pipeline for the application, 

tkn pipeline start build-and-deploy \
    -w name=inderjitsanhotra-dev \
    -p deployment-name=simplesender-api \
    -p git-url=https://github.com/ISingh2015/simplesender.git \
    -p IMAGE='image-registry.openshift-image-registry.svc:5000/$(context.pipelineRun.namespace)/simplesender' \--use-param-defaults
