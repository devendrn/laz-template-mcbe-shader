# laz-template-mcbe-shader

A template project for Lazurite. 

# Setup

- Install [Python](https://www.python.org/) 3.11 or higher.
- Install [Lazurite](https://veka0.github.io/lazurite/#installation).
- Download [shaderc](https://github.com/veka0/bgfx-mcbe/releases/tag/binaries) binary and place it in the project root.
- Create a folder `src-materials` in the project root and put vanilla `materials.bin` files inside it.

Once set up, the project directory should look like this:
```
├─ src-materials/
│  ├─ Sky.material.bin # or Sky.material.json
│  └─ ...
├─ proj/
│  ├─ ...
│  └─ project.json
├─ shaderc # or shaderc.exe
├─ LICENSE
└─ README.md
```

# Building 

To build the shader, run:
```
lazurite build ./proj
```
This will build the project inside `./proj`.

You can create multiple shader projects if you wish.
```
├─ mango-shader/
│  ├─ ...
│  └─ project.json
├─ pineapple-shader/
│  ├─ ...
│  └─ project.json
```

```
lazurite build ./pineapple-shader
```

# More info

Read [Lazurite docs](https://veka0.github.io/lazurite/) to learn more. 


