$input a_color0, a_position
#ifdef INSTANCING
$input i_data1, i_data2, i_data3
#endif
$output v_color0

#include <bgfx_shader.sh>

uniform vec4 SkyColor;
uniform vec4 FogColor;

void main() {
  #ifdef INSTANCING
    mat4 model = mtxFromCols(i_data1, i_data2, i_data3, vec4(0.0, 0.0, 0.0, 1.0));
  #else
    mat4 model = u_model[0];
  #endif
  vec4 worldPos = mul(model, vec4(a_position, 1.0));

  v_color0 = mix(SkyColor, FogColor, a_color0.x);

  gl_Position = mul(u_viewProj, vec4(worldPos.xyz, 1.0));
}

