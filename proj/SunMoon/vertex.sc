$input a_color0, a_position, a_texcoord0
#ifdef INSTANCING
$input i_data1, i_data2, i_data3
#endif
$output v_texcoord0

#include <bgfx_shader.sh>

void main() {
  #ifdef INSTANCING
    mat4 model = mtxFromCols(i_data1, i_data2, i_data3, vec4(0.0, 0.0, 0.0, 1.0));
  #else
    mat4 model = u_model[0];
  #endif
  vec4 worldPos = mul(model, vec4(a_position, 1.0));


  v_texcoord0 = a_texcoord0;

  gl_Position = mul(u_viewProj, vec4(worldPos.xyz, 1.0));
}
