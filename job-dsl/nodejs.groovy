job('RG NodeJS example') {
    scm {
        git('git://github.com/rgarnacho/docker-demo.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('rgarnacho@gmail.com')
        }
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        // echo 'npm install'
        bat 'C://tools//Jenkins//tools\jenkins.plugins.nodejs.tools.NodeJSInstallation//nodejs//npm.cmd install'
    }
}
