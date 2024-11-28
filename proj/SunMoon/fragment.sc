$input v_texcoord0

#include <bgfx_shader.sh>

uniform vec4 SunMoonColor;

SAMPLER2D_AUTOREG(s_SunMoonTexture);

void main() {
  gl_FragColor = SunMoonColor * texture(s_SunMoonTexture, v_texcoord0);
}


